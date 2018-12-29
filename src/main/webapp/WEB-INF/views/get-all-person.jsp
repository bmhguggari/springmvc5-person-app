<%@ include file="header.jsp" %>
<div>
            <h1>Person Details</h1>
            <table > 
            <c:forEach items="${persons}" var="person" >     
             <tr>    
              <td>Name : </td>   
              <td>${person.name}</td>  
             </tr>    
             <tr>    
              <td>Address :</td>    
             <td>${person.address}</td>  
             </tr>   
             <tr>    
              <td>Mobile :</td>    
              <td>${person.mobile}</td> 
             </tr> 
             <tr>    
              <td>Email :</td>    
              <td>${person.email}</td>  
             </tr>
             <tr>    
              <td>Update? : </td>   
              <td><a href="update-person?id=${person.id}" >Go ..</a></td>  
             </tr>  
             </c:forEach>  
            </table>    
</div>   
<%@ include file="footer.jsp" %>