<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/vue@2.7.13/dist/vue.js"></script>
<script src="https://unpkg.com/axios"></script>

<div id='app'>
  <add-component></add-component>
  <list-component></list-component>
</div>

<script>
  function queryStr(obj = {}) {
    let str = "";
    for (let prop in obj) {
      str += prop + '=' + obj[prop] + '&';
    }
    return str.substring(0, str.length - 1);
  }

  var bookAry = []
  let counter = {
    counter: 10
  };

  // add component & list component .

  const addComponent = {
    template: `
    <div id="addItem">
      <table class="table">
        <tr>
          <th>{{codeLabel}}</th>
          <td><input type="text" v-model="bookCode"></td>
        </tr>
        <tr>
          <th>{{titleLabel}}</th>
          <td><input type="text" v-model="bookTitle"></td>
        </tr>
        <tr>
          <th>{{authorLabel}}</th>
          <td><input type="text" v-model="bookAuthor"></td>
        </tr>
        <tr>
          <th>{{pressLabel}}</th>
          <td><input type="text" v-model="bookPress"></td>
        </tr>
        <tr>
          <th>{{priceLabel}}</th>
          <td><input type="text" v-model="bookPrice"></td>
        </tr>
        <tr>
          <td align="center" colspan="2">
            <button class='btn btn-primary' v-on:click="addBook()">등록</button>
            <button class='btn btn-danger' v-on:click="delSelectedBook()">선택삭제</button>
          </td>
        </tr>
      </table>
    </div>  
  `,
    //props: ['counter'],
    data: function () {
      return {
        codeLabel: '도 서 코 드',
        titleLabel: '도 서 명',
        authorLabel: '저 자',
        pressLabel: '출 판 사',
        priceLabel: '가 격',
        counter: 10,
        // init value.
        bookCode: 'B001',
        bookTitle: 'This is Java',
        bookAuthor: 'Kim Java',
        bookPress: 'JavaPress',
        bookPrice: 20000
      }
    },
    methods: {
      addBook: function () {

        if (!this.bookCode || !this.bookTitle || !this.bookAuthor || !this.bookPress || !this.bookPrice) {
          alert('required field.')
          return;
        }
        let book = {
          bookCode: this.bookCode,
          bookTitle: this.bookTitle,
          bookPress: this.bookPress,
          bookAuthor: this.bookAuthor,
          bookPrice: this.bookPrice
        }
        let param = queryStr(book);

        fetch('addBookJson.do', {
            method: 'post',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: param
          })
          .then(resolve => resolve.json())
          .then(result => {
            console.log(result)
            if (result.retCode == 'Success') {
              console.log(this.$parent)
              //this.bookLists.push(result)
              this.$parent.bookLists.push(book)
            } else {
              alert('error!!')
            }
          })
          .catch(reject => {
            alert("처리 중 에러 발생!")
          })

      },
      delSelectedBook: function () {

        app.$children[1].deletedTarget.forEach(function (book) {

          app.bookLists.forEach((tbook, idx) => {
            console.log(book, tbook.bookCode)
            if (book == tbook.bookCode) {
              axios.get('deleteBookJson.do?bcode=' + book)
                // axios({
                //   url: 'deleteBookJson.do',
                //   method: 'post',
                //   data: {
                //     bcode: book
                //   }
                //})
                .then(response => {
                  console.log(response)
                  if (response.data.retCode == 'Success')
                    app.bookLists.splice(idx, 1)
                  else
                    alert('error occurred!')
                }).catch(reject => {
                  console.log(reject)
                })
            }
          })
        })
      }
    }
  };

  const listComponent = {
    template: `
    <div>
      <table class="table">
        <thead>
          <tr>
            <th><input type="checkbox"></th>
            <th>도서코드</th>
            <th>책제목</th>
            <th>저자</th>
            <th>출판사</th>
            <th>가격</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="book in bookList">
            <td><input type="checkbox" v-bind:value="book.bookCode" v-model="deletedTarget"></td>
            <td>{{book.bookCode}}</td>
            <td>{{book.bookTitle}}</td>
            <td>{{book.bookAuthor}}</td>
            <td>{{book.bookPress}}</td>
            <td>{{book.bookPrice}}</td>
            <td><button v-on:click="deleteBook(book.bookCode)">삭제</button></td>
          </tr>
        </tbody>
      </table>
    {{deletedTarget}}
    </div>
    `,
    data: function () {
      return {
        bookList: bookAry,
        deletedTarget: []
      }
    },
    methods: {
      deleteBook: function (book_code) {
        fetch('deleteBookJson.do', {
            method: 'post',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: 'bcode=' + book_code
          })
          .then(resolve => resolve.json())
          .then(result => {
            console.log(result)
            if (result.retCode == 'Success') {
              this.bookList.forEach((book, idx, ary) => {
                if (book.bookCode == book_code) {
                  ary.splice(idx, 1);
                }
              })
            } else if (result.retCode == 'Fail') {
              alert('error code')
            }
          })
          .catch(
            reject => console.log(reject)
          )
      }
    }
  }

  // 인스턴스 선언 초기화.
  var app = new Vue({
    el: '#app',
    data: {
      bookLists: bookAry
    },
    components: {
      'add-component': addComponent,
      'list-component': listComponent
    },
    methods: {},
    created: function () {

      // fetch('bookListJson.do')
      //   .then(resolve => resolve.json())
      //   .then(result => {
      //     console.log(result);
      //     result.forEach(book => {
      //       this.bookLists.push(book);
      //     })
      //   })
      //   .catch(err => console.log(err))
      axios.get('bookListJson.do')
        .then(resolve => {
          console.log(resolve)
          resolve.data.forEach(book => {
            this.bookLists.push(book);
          })
        }).catch(error => {
          console.log(error)
        })
    }
  })

  console.log(app)
</script>