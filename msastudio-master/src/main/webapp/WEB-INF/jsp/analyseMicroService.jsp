<%@include file="masheader.jsp" %>  


<script>
    function GetFileSize() {
        var fi = document.getElementById('inputfileupload'); // GET THE FILE INPUT.

        // VALIDATE OR CHECK IF ANY FILE IS SELECTED.
        if (fi.files.length > 0) {
            // RUN A LOOP TO CHECK EACH SELECTED FILE.
            for (var i = 0; i <= fi.files.length - 1; i++) {

                var fsize = fi.files.item(i).size;      // THE SIZE OF THE FILE.
                document.getElementById('fp').innerHTML =
                    document.getElementById('fp').innerHTML + '( ' +
                        '<I>File Size :' + Math.round((fsize / 1024)) + ' KB)';
            }
        }
    }
</script>


<div class="text-center col-xs-4 col-md-4"></div>
<div class="text-center col-xs-4 col-md-4">
	<form:form method="post" modelAttribute="uploadForm" action="analyseresult" enctype="multipart/form-data">
		<div th:if="${message}">
			<h2 th:text="${message}" />
		</div>
		<div class="form-group ">
			<div class="col-xs-12">
				<label for="projectType"><Strong>Technology Stack</Strong></label>
				<div><p><form:errors cssClass="error-text" path="projectType" /></p></div>
				<select name="projectType" class="breadcrumb" id="projectType">
					<option value=''>------------- Select a stack-------------</option>
					<c:forEach var="techInfo" items="${technologies}">
						<c:choose>
							<c:when test="${selectedId eq techInfo.id}">
								<option value="${techInfo.id}" selected >${techInfo.technology}</option>
							</c:when>
							<c:otherwise>
								<option value="${techInfo.id}" >${techInfo.technology}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div style="margin: 7px;" class="col-xs-12 col-md-12">
				<label for="inputfileupload"><Strong>Upload Source Code</Strong> </label>
				<br><p style='font-size:10px;'>(Source code of a Project to be analysed. In .zip format)</p>
				<div><p><form:errors cssClass="error-text" path="file" /></p></div>
				<input type="file" name="file"
					id="inputfileupload" class="btn btn-default col-xs-12 col-md-12"
					onchange="GetFileSize()" />
				<p id="fp"></p>
			</div>
		</div>
		<div class="form-group">
			<button type="submit" align="center" class="btn btn-success btn-md">Submit</button>
		</div>
	</form:form>

</div>
<div class="text-center col-xs-4 col-md-4"></div>
</body>
</html>
