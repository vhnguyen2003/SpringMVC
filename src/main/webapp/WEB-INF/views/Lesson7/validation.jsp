<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> --%>
<%@include file="/WEB-INF/views/include/header.jsp"%>

<style>
.errors {
	color: red, font-style: italic;
}
</style>

<%@include file="/WEB-INF/views/include/menu.jsp"%>
<main class="container">
	<div class="row justify-content-md-center">
		<section class="vh-100">
			<div class="container-fluid h-custom">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-md-9 col-lg-6 col-xl-5">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
							class="img-fluid" alt="Sample image">
					</div>
					<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
						<form:form method="POST" action="Lesson7/index.htm"
							modelAttribute="user">
							<div class="divider d-flex align-items-center my-4">
								<p class="text-center fw-bold mx-3 mb-0">Đăng nhập</p>
							</div>

							<!-- Email input -->
							<div data-mdb-input-init class="form-outline mb-4">
								<label class="form-label" for="form3Example3">Tên đăng
									nhập</label>
								<form:input path="id" type="text" id="form3Example3"
									class="form-control form-control-lg"
									placeholder="Tên đăng nhập" />
								<label class="form-label mb-1" for="form3Example4">
									<h6 class="text-sm">
										<form:errors path="id" cssClass="errors" />
									</h6>
								</label>
							</div>

							<!-- Password input -->
							<div data-mdb-input-init class="form-outline mb-3">
								<label class="form-label" for="form3Example4">Password</label>
								<form:input path="password" type="password" id="form3Example4"
									class="form-control form-control-lg"
									placeholder="Enter password" />
								<label class="form-label mb-1" for="form3Example4">
									<h6 class="text-sm">
										<form:errors path="password" cssClass="errors" />
									</h6>
								</label>
							</div>

							<div class="d-flex justify-content-between align-items-center">
								<!-- Checkbox -->
								<div class="form-check mb-0">
									<input class="form-check-input me-2" type="checkbox" value=""
										id="form2Example3" /> <label class="form-check-label"
										for="form2Example3"> Remember me </label>
								</div>
								<a href="#!" class="text-body">Forgot password?</a>
							</div>

							<div class="text-center text-lg-start mt-4 pt-2">
								<button type="submit" data-mdb-button-init data-mdb-ripple-init
									class="btn btn-primary btn-lg"
									style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
								<p class="small fw-bold mt-2 pt-1 mb-0">
									Don't have an account? <a href="#!" class="link-danger">Register</a>
								</p>
							</div>

						</form:form>
					</div>
				</div>
			</div>
			<div
				class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
				<!-- Copyright -->
				<div class="text-white mb-3 mb-md-0">Copyright © 2020. All
					rights reserved.</div>
				<!-- Copyright -->

				<!-- Right -->
				<div>
					<a href="#!" class="text-white me-4"> <i
						class="fab fa-facebook-f"></i>
					</a> <a href="#!" class="text-white me-4"> <i
						class="fab fa-twitter"></i>
					</a> <a href="#!" class="text-white me-4"> <i class="fab fa-google"></i>
					</a> <a href="#!" class="text-white"> <i class="fab fa-linkedin-in"></i>
					</a>
				</div>
				<!-- Right -->
			</div>
		</section>
	</div>
</main>
<%@include file="/WEB-INF/views/include/footer.jsp"%>