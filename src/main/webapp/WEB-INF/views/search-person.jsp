<%@ include file="header.jsp" %>
<div>
   <h1>Search Person</h1>  
   <form:form method="post" action="search-person">    
    <table>    
     <tr>    
      <td>Id : </td>   
      <td><input type="text" name="id" /></td>  
     </tr>   
      <tr>    
      <td> </td>    
      <td><input type=submit value="Search" /></td>    
     </tr>  
    </table>    
   </form:form>
</div>    
<%@ include file="footer.jsp" %>