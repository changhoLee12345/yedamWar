<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id='app'>
  <div id="addItem">
    <table class="table">
      <tr>
        <th>도서코드</th>
        <td><input type="text" name="bcode" id="bcode"></td>
      </tr>
      <tr>
        <th>도서명</th>
        <td><input type="text" name="bname" id="bname"></td>
      </tr>
      <tr>
        <th>저자</th>
        <td><input type="text" name="bauthor" id="bauthor"></td>
      </tr>
      <tr>
        <th>출판사</th>
        <td><input type="text" name="bpress" id="bpress"></td>
      </tr>
      <tr>
        <th>가격</th>
        <td><input type="text" name="bprice" id="bprice"></td>
      </tr>
      <tr>
        <td colspan="2"><button onclick="addBook()"></td>
      </tr>
    </table>
  </div>
  
  <table class="table">
    <thead>
      <tr>
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
        <td>{{book.bookCode}}</td>
        <td>{{book.bookTitle}}</td>
        <td>{{book.bookAuthor}}</td>
        <td>{{book.bookPress}}</td>
        <td>{{book.bookPrice}}</td>
        <td><button v-on:click="deleteBook(book.bookCode)">삭제</button></td>
      </tr>
    </tbody>
  </table>
</div>

<script>
  var bookAry = []
  var app = new Vue({
    el: '#app',
    data: {
      bookList: bookAry
    },
    methods: {
      deleteBook: function (book_code) {
        console.log(book_code)
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
    },
    created: function () {
      console.log('created');
      fetch('bookListJson.do')
        .then(resolve => resolve.json())
        .then(result => {
          console.log(result);
          result.forEach(book => {
            this.bookList.push(book);
          })
        })
        .catch(err => console.log(err))
    }
  })

  console.log(app)
</script>