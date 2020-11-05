<%@page import="com.crud.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAOImpl"%>
<html>
<head>
<link rel="stylesheet" href="./assets/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
		<div class="jumbotron py-5">
			<h3 class="h3 mb-0">Showing all the Products</h3>
		</div>

		<%
			ProductDAOImpl impl = new ProductDAOImpl();
		%>
		<%
			List<Product> list = impl.view();
		%>
		<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Product ID</th>
      <th scope="col">Category ID</th>
      <th scope="col">Product Name</th>
      <form action="SortServlet" method="get">
      <fieldset>
      <th scope="col">
      CostPrice
      <button type="submit" name="sort" value="asc" class="btn btn-primary"><i class="fa fa-sort-numeric-asc" aria-hidden="true"></i></button>
      <button type="submit" name="sort" value="desc"  class="btn btn-primary"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i></button>
      </th>
      </fieldset>
      </form>
      <th scope="col">SalePrice</th>
      <th scope="col">Product Description</th>
    </tr>
  </thead>
  <tbody>

		<%
		
			for (Product prod : list) {
		%>

		<tr class="table-primary">
      <th scope="row"><%= prod.getProductID() %></th>
      <td><%= prod.getCategoryID() %></td>
      <td><%= prod.getProductName() %></td>
      <td><%= prod.getCostPrice() %></td>
      <td><%= prod.getSalePrice() %></td>
      <td><%= prod.getProductDescription() %></td>
      
    </tr>

		<%
			}
		%>

	</tbody>
</table> 
</div>
</body>
</html>