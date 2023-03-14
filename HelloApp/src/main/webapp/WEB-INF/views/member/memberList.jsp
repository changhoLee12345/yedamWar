<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>회원리스트</h3>
<section class="pt-4">
    <div class="container px-lg-5">
        <!-- Page Features-->
        <div class="row gx-lg-5">

            <div class="col-lg-6 col-xxl-4 mb-5">
                <div class="card bg-light border-0 h-100">
                    <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-4 mt-n4">
                            <i class="bi bi-collection"></i>
                        </div>
                        <h2 class="fs-4 fw-bold">Fresh new layout</h2>
                        <p class="mb-0">With Bootstrap 5, we've created a fresh new layout for this template!</p>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>


<table class="table">
    <thead>
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
            <th>권한</th>
            <th>등록일</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="member" items="${members }">
            <tr>
                <td><a href="memberForm.do?id=${member.id }">${member.id }</a></td>
                <td>${member.name }</td>
                <td>${member.email }</td>
                <td>${member.responsibility }</td>
                <td>${member.cdate }</td>
            </tr>
        </c:forEach>
    </tbody>
</table>