<%@ include file="header.jsp" %>
<div>
            <h1>Update Person</h1>  
           <form:form method="post" action="update-person">    
            <table > 
            <tr>    
              <td></td>   
              <td><form:hidden path="id"  /></td>  
             </tr>   
             <tr>    
              <td>Name : </td>   
              <td><form:input path="name"  /></td>  
             </tr>    
             <tr>    
              <td>Address :</td>    
              <td><form:input path="address" /></td>  
             </tr>   
             <tr>    
              <td>Mobile :</td>    
              <td><form:input path="mobile" /></td>  
             </tr> 
             <tr>    
              <td>Mail :</td>    
              <td><form:input path="email" /></td>  
             </tr>  
             <tr>    
              <td> </td>    
              <td><input type="submit" value="Update" /></td>    
             </tr>    
            </table>    
           </form:form>    
</div>
<%@ include file="footer.jsp" %>