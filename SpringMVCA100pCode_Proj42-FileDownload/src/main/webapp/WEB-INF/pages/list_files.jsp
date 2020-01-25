<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color:green;text-align: center;">Choose A File To Download</h1>
<c:choose>
<c:when test="${!empty filesList}">
<table align="center" border="1" cols='2'>
<c:forEach var="file" items="${filesList}">
<tr>
<td>${file}</td>
<td><a href="download.htm?file_name=${file}">Download</a></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<p style="color:red;">No files are uploaded</p>
</c:otherwise>
</c:choose>
