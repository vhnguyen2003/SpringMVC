<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#"
					tabindex="-1" aria-disabled="true">Disabled</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown01"
					data-bs-toggle="dropdown" aria-expanded="false">Bài học</a>
					<ul class="dropdown-menu" aria-labelledby="dropdown01">
						<li><a class="dropdown-item" href="#">Bài 1: Giới thiệu
								Spring MVC</a></li>
						<li><a class="dropdown-item" href="#">Bài 2: Controller</a></li>
						<li><a class="dropdown-item" href="#">Bài 3: Làm việc với
								Form</a></li>
						<li><a class="dropdown-item" href="JSTL/index.htm">Bài 4:
								EL và JSTL</a></li>
						<li><a class="dropdown-item" href="Lesson5/index.htm">Bài
								5: Bean và Dependency Injection</a></li>
						<li><a class="dropdown-item" href="Lesson6/index.htm">Bài
								6: Hibernate</a></li>
						<li><a class="dropdown-item" href="Lesson7/index.htm">Bài
								7: Validation</a></li>

					</ul></li>
			</ul>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>