<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>

<body>

	<!-- Navbar Starting -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light py-3">
		<a class="navbar-brand" href="#"> <span>Shop Online</span> <i
			class="fa-solid fa-truck-fast fa-2xl" style="color: #2756c4;"></i></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">

				<li class="nav-item dropdown border-left"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Categories </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">

						<c:forEach items="${category }" var="cat">
							<a class="dropdown-item hovaravle"
								href="${pageContext.request.contextPath }/products/${cat.getId() }">${cat.categoryName }</a>
						</c:forEach>

					</div></li>
				<li class="nav-item border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/">Home <i
						class="fa-solid fa-house fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/cart">Cart <i
						class="fa-solid fa-cart-shopping fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><a class="nav-link"
					href="${pageContext.request.contextPath }/wishlist">Wish List <i
						class="fa-solid fa-heart fa-beat fa-lg" style="color: #2756c4;"></i></a></li>
				<li class="nav-item mr-1 border-left"><c:set var="user"
						scope="session" value="${currentuser}" /> <c:choose>
						<c:when test="${user == null}">
							<a class="nav-link"
								href="${pageContext.request.contextPath }/auth">Login/Register
								<i class="fa-solid fa-circle-user fa-lg" style="color: #2756c4;"></i>
							</a>
						</c:when>
						<c:otherwise>
							<a class="nav-link"
								href="${pageContext.request.contextPath }/auth">${user.userId }<i
								class="fa-solid fa-circle-user fa-lg" style="color: #2756c4;"></i></a>
						</c:otherwise>
					</c:choose></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<!--  Navbar Ending -->

	<!-- Starting Table -->

	<c:set var="total" scope="session" value="${total }" />

	<div class="container mt-3">
		<div class="row">
			<div class="col">


				<div class="card-header">
					<h3>Order Detail</h3>
				</div>

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Product Name</th>
							<th scope="col">Size</th>
							<th scope="col">Color</th>
							<th scope="col">Price</th>
							<th scope="col">Quantity</th>
							<th scope="col">Sub-Total</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${cartItems }" var="item">
							<tr>
								<td>${item.getProduct().productName }</td>
								<td>${item.getProduct().productSize }</td>
								<td>${item.getProduct().productColor }</td>
								<td>${item.getProduct().price}</td>
								<td>${item.quantity }</td>
								<td>${item.quantity * item.getProduct().price}</td>

							</tr>
						</c:forEach>

						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td>Total</td>
							<td>${total }</td>
						</tr>


					</tbody>
				</table>

			</div>

		</div>

		<div class="row">

			<div class="col">

				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Select Payment
						Method</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

						<c:forEach items="${methods }" var="method">
							<a class="dropdown-item"
								onclick="payshowhide(${method.methodId })">${method.methodType }</a>
						</c:forEach>

					</div>
				</div>

			</div>

		</div>

		<div class="row mt-5">
			<div class="col">

				<form id="card-details" class="allign-items-center border p-5"
					style="display: none" action="">
					<div class="form-group">
						<label for="inputAddress">Card Number</label> <input type="text"
							class="form-control" id="inputAddress" placeholder="012 345 6789">
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputEmail4">Exp Date</label> <input type="email"
								class="form-control" id="inputEmail4" placeholder="MM/YY">
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">CVV</label> <input type="password"
								class="form-control" id="inputPassword4" placeholder="000">
						</div>
					</div>
					<button type="button" class="btn btn-primary btn-md btn-block">Place
						Order</button>
				</form>


				<form id="UPI-details" class="allign-items-center border p-5"
					style="display: none" action="">
					<div class="form-group">
						<label for="inputAddress">UPI Id</label> <input type="text"
							class="form-control" id="inputAddress" placeholder="abc@upiid">
					</div>
					<button type="button" class="btn btn-primary btn-md btn-block">Place
						Order</button>
				</form>

				<form id="Case-details" class="allign-items-center border p-5"
					action="" style="display: none">
					<div class="form-group">
						<label for="inputAddress">Mobile</label> <input type="text"
							class="form-control" id="inputAddress" placeholder="0123456789">
					</div>
					<button type="button" class="btn btn-primary btn-md btn-block">Place
						Order</button>
				</form>

			</div>
		</div>
	</div>




	<script type="text/javascript">
		function payshowhide(id) {

			if (id == 1) {
				var x = document.getElementById("card-details");
				var y = document.getElementById("UPI-details");
				var z = document.getElementById("Case-details");

				x.style.display = "block";
				y.style.display = "none";
				z.style.display = "none";
			} 
			else if (id == 2) {
				var x = document.getElementById("card-details");
				var y = document.getElementById("UPI-details");
				var z = document.getElementById("Case-details");

				x.style.display = "block";
				y.style.display = "none";
				z.style.display = "none";
			} 
			else if (id == 3) {
				var x = document.getElementById("card-details");
				var y = document.getElementById("UPI-details");
				var z = document.getElementById("Case-details");

				x.style.display = "none";
				y.style.display = "Block";
				z.style.display = "none";
			} 
			else{
				var x = document.getElementById("card-details");
				var y = document.getElementById("UPI-details");
				var z = document.getElementById("Case-details");

				x.style.display = "none";
				y.style.display = "none";
				z.style.display = "Block";
			}
		}
	</script>


</body>

</html>