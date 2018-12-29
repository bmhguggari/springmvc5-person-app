<%@ include file="header.jsp" %>
<div>
            <h1>Add New Person</h1>  
           <form:form method="post" action="create-person">    
            <table >    
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
              <td><input type="submit" value="Create" /></td>    
             </tr>    
            </table>    
           </form:form>    
</div>
<%@ include file="footer.jsp" %>