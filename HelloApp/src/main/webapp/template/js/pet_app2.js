console.log('start')

App = {
  adoptAry: [],
  init: async function () {
    // Load pets.
    $.getJSON('./json/pets.json', function (data) {
      console.log('2')
      var petsRow = $('#petsRow');
      var petTemplate = $('#petTemplate');
      //var msg= "";
      for (i = 0; i < data.length; i++) {
        //msg+=data[i].id+"\t"+data[i].name +"\t"+ data[i].picture+"\t"+data[i].age+"\t"+data[i].breed+"\t"+data[i].location+"\n";
        petTemplate.find('.panel-title').text(data[i].name);
        petTemplate.find('img').attr('src', data[i].picture);
        petTemplate.find('.pet-breed').text(data[i].breed);
        petTemplate.find('.pet-age').text(data[i].age);
        petTemplate.find('.pet-location').text(data[i].location);
        petTemplate.find('.btn-adopt').attr('data-id', data[i].id);

        petsRow.append(petTemplate.html());
      }
    });
    return await App.initContract();
  }, // end of init;

  initContract: async function () {
    // 초기화작업.
    await App.initMarkData();
    //App.markAdopted();
    return App.bindEvents();
  }, // end of initContract;

  bindEvents: function () {
    // 입양버튼에 이벤트 등록.
    $(document).on('click', '.btn-adopt', App.handleAdopt);
  },

  initMarkData: function () {
    // json 정보를 활용해서 입양처리하기.
    fetch('./json/adopted.json')
      .then(response => response.json())
      .then(function (adopters) {
        console.log('6')
        App.adoptAry = adopters;
        for (i = 0; i < App.adoptAry.length; i++) {
          $('.panel-pet').eq(App.adoptAry[i]).find('button').text('Success').attr('disabled', true);
        }
      }).catch(function (err) {
        console.log(err.message);
      });
  },

  markAdopted: function () {
    // 입양처리.
    for (i = 0; i < App.adoptAry.length; i++) {
      $('.panel-pet').eq(App.adoptAry[i]).find('button').text('Success').attr('disabled', true);
    }
  }, // end of markAdopted;

  handleAdopt: function (event) {
    // 사용자화면에서 입양버튼 클릭 시 처리.
    event.preventDefault();

    var petId = parseInt($(event.target).data('id'));
    App.adoptAry.push(petId);

    App.markAdopted();

    // fetch('')
    //   .then(function (instance) {
    //     // Execute adopt as a transaction by sending account
    //     return adoptionInstance.adopt(petId, {
    //       from: account
    //     });
    //   }).then(function (result) {
    //     return App.markAdopted();

    //   }).catch(function (err) {
    //     console.log(err.message);
    //   });
  } // end of handleAdopt;

}; // end of App;
console.log('end');

$(function () {
  App.init();
});