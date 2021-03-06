<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Demonstration</title>
   </head>

   <body>
      <h2>Protect the data</h2>
      <form:form method = "POST" action = "protect" modelAttribute="dataToBeProtected">
         <table>
            <tr>
               <td><form:label path = "clearValue">Clear value</form:label></td>
               <td><form:input path = "clearValue" /></td>
            </tr>
            <tr>
               <td><form:label path = "dataElementName">Data element name</form:label></td>
               <td>
               		<form:select path = "dataElementName" >
               			<form:option value = "NONE" label = "Select"/>
               			<form:options items = "${dataElementsList}" />
               		</form:select>
               </td>
            </tr>
            <tr>
               <td><form:label path = "userId">userId</form:label></td>
               <td><form:input path = "userId" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
   
</html>