<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-5">
		<div class="text-center">
			<h2>Change the product details</h2>
		</div>
		<div class="mx-auto">
			<form action="update-product-${product.id }" method="post">
			<div class="form-group">
					<label for="id">Product Id</label> <input type="text"
						class="form-control" id="productid" aria-describedby="emailHelp"
					 name="id" value="YPROD${product.id } " disabled>
				</div>
			
				<div class="form-group">
					<label for="name">Product Name</label> <input type="text"
						class="form-control" id="productname" aria-describedby="emailHelp"
						placeholder="Enter Name" name="name" value="${product.name }">
				</div>
				<div class="form-group ">
					<label for="description">Product Description</label>
					<textarea  class="form-control" id="productdesc"
						aria-describedby="emailHelp" placeholder="Enter Description"
						name="description" rows="3">${product.description} </textarea>
				</div>
				
				<div class="form-group">
					<label for="price">Product Price</label> <input type="text"
						class="form-control" id="productprice"
						aria-describedby="emailHelp" placeholder="Enter Price"
						name="price" value="${product.price }">
				</div>
				<div class=" container text-center">
					<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
					<button type="submit" class="btn btn-warning">Update</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>