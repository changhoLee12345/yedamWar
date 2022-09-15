// user.js

document.addEventListener('DOMContentLoaded', function () {
    // 리스트 출력.
    fetch('../users')
        .then(response => response.json())
        .then(showList)
        .catch(error => console.log(error));

})

function showList(arg) {
    var attach = document.querySelector('div.container tbody');
    console.log('showList: ', arg)
    for (let i = 0; i < arg.length; i++) {
        attach.appendChild(makeTr(arg[i]));
    }
}

function makeTr(row) {

    var newTr = document.querySelector('div.container tbody>tr#sample').cloneNode(true);
    newTr.setAttribute('id', row.id);
    newTr.style.display = '';
    newTr.childNodes[1].textContent = row.id;
    newTr.childNodes[3].textContent = row.password;
    newTr.childNodes[5].textContent = row.name;
    newTr.childNodes[7].textContent = row.role;
    newTr.childNodes[9].childNodes[1].onclick = searchFnc;
    newTr.childNodes[9].childNodes[3].onclick = deleteFnc;

    return newTr;

}

function deleteFnc(e) {
    var del_id = e.target.parentNode.parentNode.childNodes[1].textContent;

    fetch('../users/' + del_id, {
            method: 'delete'
        })
        .then(response => response.json())
        .then(result => {
            console.log(result);
            e.target.parentNode.parentNode.remove();
        })
        .catch(err => console.log(err));
}

function searchFnc(e) {
    var find_id = e.target.parentNode.parentNode.childNodes[1].textContent;

    fetch('../users/' + find_id, {
            method: 'get',
            // headers: {
            // 'Content-type': 'application/x-www-form-urlencoded'
            // },
            // body: JSON.stringify({
            //     id: find_id
            // }
        })
        .then(response => response.json())
        .then(searchCallBack)
        .catch(err => console.log(err));
}

// 조회 후 화면에 출력하는 callBack
function searchCallBack(result) {
    var destForm = document.querySelector('#form1');

    destForm.id.value = result.id;
    destForm.name.value = result.name;
    destForm.password.value = result.password;
    destForm.querySelectorAll('select[name="role"]>option').forEach(function (item) {
        item.value == result.role ? item.selected = true : item.selected = false;
    })
}

var insertBtn = document.getElementById('btnInsert');
var updateBtn = document.getElementById('btnUpdate');
var initBtn = document.getElementById('btnInit');


insertBtn.addEventListener('click', function () {
    var form = document.getElementById('form1');
    var id = form.querySelector('input[name="id"]').value;
    var name = form.querySelector('input[name="name"]').value;
    var pass = form.querySelector('input[name="password"]').value;
    var role = form.querySelector('select[name="role"]').value;
    var data = {
        id: id,
        name: name,
        password: pass,
        role: role
    };
    fetch('../users', {
            method: 'post',
            headers: {
                // 'Content-type': 'application/x-www-form-urlencoded'
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(result => {
            console.log(result);
            var attach = document.querySelector('div.container tbody');
            attach.appendChild(makeTr(data));
        })
        .catch(err => console.log(err));
});

updateBtn.addEventListener('click', function () {
    var form = document.getElementById('form1');
    var id = form.querySelector('input[name="id"]').value;
    var name = form.querySelector('input[name="name"]').value;
    var pass = form.querySelector('input[name="password"]').value;
    var role = form.querySelector('select[name="role"]').value;
    var data = {
        id: id,
        name: name,
        password: pass,
        role: role
    };
    console.log(data);
    fetch('../users', {
            method: 'put',
            headers: {
                // 'Content-type': 'application/x-www-form-urlencoded'
                'Content-type': 'application/json'
            },
            // body: 'id=' + id + '&name=' + name + '&password=' + pass + '&role=' + role
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(result => {
            console.log(result)
            var oldTr = document.getElementById(id);
            var newTr = makeTr(result);
            console.log(newTr)
            oldTr.parentNode.replaceChild(newTr, oldTr);
        })
        .catch(err => console.log(err));
})

initBtn.addEventListener('click', function () {
    document.getElementById('form1').reset();
})