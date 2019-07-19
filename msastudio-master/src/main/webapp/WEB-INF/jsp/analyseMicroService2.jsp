<%@ include file="masheader.jsp" %>  
<p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody>
         <tr>
            <td colspan="2" align="center">
			<div class="panel panel-success">
      <div class="panel-heading"><Strong>Analyse Micro Service</Strong></div>
    </div>
				<form method="post" action="/masstudio/analyseresult"  enctype="multipart/form-data">
				<div class="form-group">
				    <label for="projectname" class="col-xs-5">Project Name</label>
					<div class="col-xs-6">
					<input type="text" class="form-control" id="inputProjectName" placeholder="Project Name">
					</div>
				</div>
			  <div class="form-group">
              <label for="projectupload" class="col-xs-5">Project Uploaddddddd</label>
              <div class="col-xs-6">
                <input type="file" class="form-control" id="inputfileupload" placeholder="upload project" />
              </div>
				<div class="form-group">
					<button type="submit"  align="center" class="btn btn-success">Submit</button>
				</div>
				</form>
			</td>
          </tr>	
      </tbody>
    </table>    
	
	


</body>
</html>
