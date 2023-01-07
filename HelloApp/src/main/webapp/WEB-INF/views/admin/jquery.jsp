<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<h3>JQuery</h3>
<script>
  let obj = {
    name: 'hong',
    age: 20
  }
  console.log($.param(obj))
  $.get('https://jsonplaceholder.typicode.com/posts/1')
    .done(result => {
      console.log(result)
    })
    .fail(reject => {
      console.log(reject)
    })
    .always(result => {
      console.log('always , ', result)
    })

    $.post('')
</script>