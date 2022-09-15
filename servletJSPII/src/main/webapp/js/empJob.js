// emp.js

// empList 출력.

document.addEventListener('DOMContentLoaded', function () {
    var request = new Request('../empSelect');

    fetch(request)
        .then(response => {
            console.log(response);
            return response.json();
        })
        .then(empList)
        .catch(err => {
            console.log(err);
        })

    document.getElementById('btnUpdate').addEventListener('click', changeJobSal);

    var data = {
        department_id: 80
    }
    // getDept Test.
    fetch('../getDept', {
            method: 'post',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(result => console.log(result))
        .catch(err => console.log(err))
});

function empList(data) {
    data.forEach(makeRow);
    document.getElementById('template').style.display = 'none';
}

function makeRow(obj) {

    if (obj.employee_id >= 125 && obj.employee_id < 145) {

        var cloneN = document.getElementById('template').cloneNode(true);
        cloneN.setAttribute('id', obj.employee_id);
        cloneN.querySelector('td:nth-child(1)').textContent = obj.employee_id;
        cloneN.querySelector('td:nth-child(2)').textContent = obj.first_name + ' ' + obj.last_name;
        cloneN.querySelector('td:nth-child(3)').textContent = obj.job_id;
        cloneN.querySelector('td:nth-child(4)').textContent = obj.department_id
        cloneN.querySelector('td:nth-child(5)').textContent = obj.salary;
        cloneN.querySelector('td:nth-child(6)>button:nth-child(1)').setAttribute('data-id', obj.employee_id);
        cloneN.querySelector('td:nth-child(6)>button:nth-child(2)').setAttribute('data-id', obj.employee_id);

        document.querySelector('tbody').appendChild(cloneN);
    }

}

function findEmp(e) {

    var eid = e.target.dataset.id;
    fetch('../empSelect/' + eid)
        .then(response => response.json())
        .then(result => {

            document.forms.form1.employee_id.value = result.employee_id;
            document.forms.form1.first_name.value = result.first_name;
            document.forms.form1.last_name.value = result.last_name;
            document.forms.form1.email.value = result.email;

            var tday = new Date(result.hire_date);
            var mon = (tday.getMonth() + 1);
            mon = mon < 10 ? '0' + mon : mon;
            var day = tday.getDate();
            day = day < 10 ? '0' + day : day;

            document.forms.form1.hire_date.value = '' + tday.getFullYear() + '-' + mon + '-' + day;
            document.querySelectorAll('#form1 select[name="job_id"] option').forEach(function (option) {
                if (option.value == result.job_id) {
                    option.selected = true;
                }
            })
            document.querySelectorAll('#form1 select[name="department_id"] option').forEach(function (option) {
                if (option.value == result.department_id) {
                    option.selected = true;
                }
            })
            document.forms.form1.salary.value = result.salary;
        })
        .catch(err => console.log(err))

}

function delEmp(e) {
    console.log(e.target.dataset.id);
}


function changeJobSal() {
    console.log('change')

    var id = document.forms.form1.employee_id.value;
    var job_id = document.forms.form1.job_id.value;
    var department_id = document.forms.form1.department_id.value;
    var salary = document.forms.form1.salary.value;

    var data = {
        employee_id: id,
        job_id: job_id,
        department_name: department_id,
        salary: salary
    }

    fetch('../changeJobSal', {
            method: 'post',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(result => {
            console.log(result);
            if (result.ret_code == 'OK') {
                var desti = document.getElementById(result.employee_id);
                desti.children[2].textContent = job_id;
                desti.children[3].textContent = department_id;
                desti.children[4].textContent = salary;
                document.getElementById('form1').reset();
                alert(result.ret_msg);
            } else {
                alert(result.ret_msg);
            }
        })
        .catch(err => console.log(err))
}