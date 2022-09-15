// emp.js

var data = {
    employee_id: 127,
    job_id: 'SA_REP',
    department_name: 'Sales',
    salary: 4000
}
fetch('../changeJobSal', {
        method: 'post',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => console.log(result))
    .catch(err => console.log(err))