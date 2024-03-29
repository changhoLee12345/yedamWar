<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-lg-5">
        <a class="navbar-brand" href="./">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link${requestScope['javax.servlet.forward.servlet_path'] == '/bookList.do' ? ' active' : '' }" aria-current="page" href="bookList.do">Book List</a>
                </li>
                <li class="nav-item"><a class="nav-link${requestScope['javax.servlet.forward.servlet_path'] == '/addBookForm.do' ? ' active' : '' }" href="addBookForm.do">Add Book</a></li>
                <li class="nav-item"><a class="nav-link${requestScope['javax.servlet.forward.servlet_path'] == '/searchBookForm.do' ? ' active' : '' }" href="searchBookForm.do">Search Book</a></li>
            </ul>
        </div>
    </div>
</nav>

<p>request=> ${requestScope["javax.servlet.forward.servlet_path"] }</p>