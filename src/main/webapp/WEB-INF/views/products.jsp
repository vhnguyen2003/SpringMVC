<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> --%>
<%@include file="/WEB-INF/views/include/header.jsp"%>

<style>
.main_div {
	width: 900px;
	text-align: center;
	margin: 0;
	padding: 5px;
	border: 1px dotted orangered;
	border-radius: 5px;
	display: inline-block;
}

img {
	width: 220px;
	height: 200px;
}

.iframe-nav {
	height: 100%;
	width: 200px;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 1;
}

@
keyframes leftTo { 0%{
	opacity: 0;
	transform: translate(400%, 0);
}

100








































%
{
opacity








































:








































1






































;
transform








































:








































translate






































(








































0
,
0








































)






































;
}
}
.div-animation {
	animation-name: leftTo;
	animation-duration: 1s;
	animation-fill-mode: both;
}

.firstDiv {
	animation-delay: 0.5s;
	display: inline-block;
	margin: 0 10px 0 0;
}

.secondDiv {
	animation-delay: 1s;
	display: inline-block;
	margin: 0 10px 0 0;
}

.thirdDiv {
	animation-delay: 1.5s;
	display: inline-block;
	margin: 0 10px 0 0;
}
</style>
<%@include file="/WEB-INF/views/include/menu.jsp"%>
<main class="container">
	<div class="row justify-content-md-center">
		<div>
			${message }
			<form:form class="row g-3" modelAttribute="product" method="POST"
				action="Lesson6/index.htm">
				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="inputEmail4">Tên sản phẩm</label>
						<form:input path="product_name" type="text" class="form-control"
							id="inputEmail4" placeholder="Tên sản phẩm" />
					</div>
					<div class="form-group col-md-4">
						<label for="inputPassword4">Năm sản xuất</label>
						<form:input type="text" path="model_year" class="form-control"
							id="inputPassword4" placeholder="Năm sản xuất" />
					</div>
					<div class="form-group col-md-4">
						<label for="inputAddress">Giá</label>
						<form:input type="text" path="list_price" class="form-control"
							id="inputAddress" placeholder="Giá" />
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputStateBrand">Thương hiệu</label>
						<form:select path="brands.brand_id" items="${brandsSel}"
							itemValue="brand_id" itemLabel="brand_name" id="inputStateBrand"
							class="form-control" />

					</div>
					<div class="form-group col-md-6">
						<label for="inputStateBrand">Thể loại</label>
						<form:select path="categories.category_id" items="${categorySel}"
							itemValue="category_id" itemLabel="category_name"
							id="inputStateBrand" class="form-control" />
					</div>

				</div>
				<div class="col-12">
					<button name="${btnStatus}" class="btn btn-primary" type="submit">Save</button>
				</div>
			</form:form>
		</div>

		<div>
			<form class="form-inline my-2 my-lg-0">
				<input name="searchInput" class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button name="btnSearch"
					class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>


		<table class="table">
			<thead>
				<tr>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Nhãn hàng</th>
					<th scope="col">Thể loại</th>
					<th scope="col">Năm sản xuất</th>
					<th scope="col">Giá</th>
					<th scope="col">Chỉnh sửa</th>
					<th scope="col">Xóa</th>
				</tr>
			</thead>
			<tbody id="table_products">
				<c:forEach var="pd" items="${products}">
					<tr>
						<td>${pd.product_name}</td>
						<td>${pd.brands.brand_name}</td>
						<td>${pd.categories.category_name}</td>
						<td>${pd.model_year}</td>
						<td>${pd.list_price}</td>
						<td><a href="Lesson6/index/${pd.product_id}.htm?linkEdit">
								<img class="img-fluid"
								style="max-width: 25px; max-height: 25px; vertical-align: middle;"
								src="<c:url value='/resources/images/edit.png'/>" />
						</a></td>
						<td><a href="Lesson6/index/${pd.product_id}.htm?linkDelete"
							role="button"> <img class="img-fluid"
								style="max-width: 25px; max-height: 25px; vertical-align: middle;"
								src="<c:url value='/resources/images/delete.jpg'/>" />
						</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>


	</div>
</main>
<%@include file="/WEB-INF/views/include/footer.jsp"%>