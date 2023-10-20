App = {
	adoptedAry: [],
	init: function () {
		// adopted.json 파일의 정보를 읽어서 애완견의 정보를 활용해서 페이지 생성.
		let target = $('#petsRow');
		$.ajax({
			url: './json/pets.json',
			success: function (pets) {
				pets.forEach(pet => {
					let template = $('#petTemplate>div').clone();
					template.find('h3').text(pet.name);
					template.find('img').attr('src', pet.picture);
					template.find('span.pet-breed').text(pet.breed);
					template.find('span.pet-age').text(pet.age);
					template.find('span.pet-location').text(pet.location);
					template.find('button').attr('data-id', pet.id);
					target.append(template);
				})

				// 화면에 출력한 후에 초기처리를 진행한다.
				App.initContract();
			},
			error: function (err) {
				console.log(err);
			}
		})

	}, // end of init;

	initContract: function () {
		// initMarkData 호출.
		// bindEvents 호출.
		this.initMarkData();
		this.bindEvents();

	},

	bindEvents: function () {
		// 입양버튼에 이벤트 등록.
		$('#petsRow button.btn-adopt').on('click', function (e) {
			let petId = $(e.target).data('id');
			App.markAdopted(petId);
			App.handleAdopt();
		})
	},

	initMarkData: function () {
		// adopted.json 정보를 활용해서 입양처리하기.
		$.ajax({
			url: './json/adopted.json',
			success: function (adoptAry) {
				adoptAry.forEach(id => {
					$('button.btn-adopt').eq(id).text('Adopted').attr('disabled', true);
				})
			},
			error: function (err) {
				console.log(err);
			}
		})
	},

	markAdopted: function (id) {
		// 입양처리. adoptedAry에 추가.
		App.adoptedAry.push(id);
	},

	handleAdopt: function () {
		// 사용자화면에서 입양버튼 클릭 시 처리.
		App.adoptedAry.forEach(id => {
			$('button.btn-adopt').eq(id).text('Adopted').attr('disabled', true);
		})

	}

}; // end of App;


$(function () {
	App.init();
});