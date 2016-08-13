<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<img src="http://lorempixel.com/400/200/technics/${product.name}/" />

<form:form method="post" modelAttribute="basketItem" action="${actionUrl}">
    <form:input path="quantity" type="text" />
   <form:hidden path="productId"/>
</form:form>

<form id="addToBasket" name="addToBasket">
   <label>Quantity</label> <input type="text" name="quantity" >
    <button type="submit" name="Add"/>
    </form>