<%@ include file="masheader.jsp" %>  
<p>&nbsp;  </p>
<p>&nbsp;  </p>
<p>&nbsp;  </p>
  <!-- /.container-fluid -->
  							<form method="post" action="/masstudio/generateMicroService3">

<table width="60%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody>
         <tr>
            <td align="center" >

			<div class="panel panel-success">
				<div class="panel-heading"><Strong>Project Information</Strong></div>
			</div>
  
         <div class="form-group">
				    <label for="projectname" class="col-xs-5">Project Name</label>
					<div class="col-xs-6">
					<input type="text" class="form-control" id="inputProjectName" placeholder="Project Name" value="Allianz Rest Service Application" disabled>
					</div>
				</div>
         <div class="form-group">
				    <label for="projectname" class="col-xs-5">Group Id</label>
					<div class="col-xs-6">
					<input type="text" class="form-control" id="inputProjectName" placeholder="Group Id">
					</div>
				</div>
         <div class="form-group">
				    <label for="projectname" class="col-xs-5">Artifact Id</label>
					<div class="col-xs-6">
					<input type="text" class="form-control" id="inputProjectName" placeholder="Artifact Id">
					</div>
				</div>      
         <div class="form-group">
				    <label for="projectname" class="col-xs-5">Project Type</label>
					<div class="col-xs-1">
					 <select name="projectType" size="1" class="breadcrumb" id="projectType">
						<option>Maven</option>
						<option>Gradle</option>
					</select>
					</div>
					 </div>
					<div class="form-group">
						<div class="col-xs-10" align="center">

								<button type="button"  onClick="window.location='/masstudio/generateMicroService1';" class="btn btn-success">Previous</button>
								<button type="button" onClick="window.location='/masstudio/generateMicroService3';"  align="center" class="btn btn-success">Next</button>	
						</div>			
					</div>
		
		</td>
          </tr>
		 
		    </tbody>
    </table>  	

					</form>						


 </body>
</html>
