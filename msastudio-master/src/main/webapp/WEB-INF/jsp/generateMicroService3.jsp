<%@ include file="masheader.jsp" %>  
<p>&nbsp;  </p>
<p>&nbsp;  </p>
<p>&nbsp;  </p>
  <!-- /.container-fluid -->
  				<form method="post" action="/masstudio/generateMicroService2">

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody>
         <tr>
            <td colspan="2" align="center">
			<div class="panel panel-success">
      <div class="panel-heading"><Strong>Verify & Generate Micro Service</Strong></div>
    </div>
				 <table class = "table table-hover text-centered">
    
   <thead >
      <tr>
         <th >S.No</th>
         <th >Controller Name</th>
         <th >Access Points</th>
         <th >Controller Method</th>
         <th >Method Reference</th>
         <th >Sequence Flow</th>
      </tr>
   </thead>   
   <tbody>
      <tr class="info">
         <td>1</td>
         <td>Catalogue Controller</td>
         <td>/getProductCatalogue</td>
         <td>listProducts</td>
         <td>getElectronics</td>
         <td>ConnectElectronics - > GetStoreList -> Retrive Store Products  </td>
      </tr>	  
	   <tr class="success">
         <td>2</td>
         <td>Catalogue Controller</td>
         <td>/getProductCatalogue</td>
         <td>listProducts</td>
         <td>getElectricals</td>
         <td>getElectronicsStores - > iterateProducts - > Convert</td>
      </tr>	  
	   <tr class="info">
         <td>3</td>
         <td>Catalogue Controller</td>
         <td>/getProductCatalogue</td>
         <td>listProducts</td>
         <td>getBooks</td>
         <td>getVendors -> checkIsAuthorized -> getAllBooks -> Consolidate </td>
      </tr>	  
      <tr class="success">
         <td>4</td>
         <td>Catalogue Controller</td>
         <td>/getProductCatalogue</td>
         <td>listProducts</td>
         <td>getGadgets</td>
         <td>getRetailers - > checkGadgets - > Consolidate 	</td>
      </tr>     
</table>

			
			</td>
          </tr>	
      </tbody>
    </table>  	
	<p>&nbsp;</p>
	<table width="50%" border="0" height="100%" align="center" cellpadding="0" cellspacing="0">
      <tbody>
         <tr>
            <td  >

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
					<input type="text" class="form-control" id="inputProjectName" placeholder="Group Id" value="com.hcl.microservice" disabled>
					</div>
				</div>
         <div class="form-group">
				    <label for="projectname" class="col-xs-5">Artifact Id</label>
					<div class="col-xs-6">
					<input type="text" class="form-control" id="inputProjectName" placeholder="Artifact Id" value="allianzmicroservice" disabled>
					</div>
				</div>      
         <div class="form-group">
				    <label for="projectname" class="col-xs-5">Project Type</label>
					<div class="col-xs-1">
					 <select name="projectType" size="1" class="breadcrumb" id="projectType" disabled>
						<option>Maven</option>
						<option>Gradle</option>
					</select>
					</div>
		 </div>
			<div class="form-group">
				<div class="col-xs-10" align="center">
					<button type="button"   onClick="window.location='/masstudio/generateMicroService2';" class="btn btn-success">Previous</button>
					<button type="button"  align="center" class="btn btn-success">Generate Micro Service</button>		
				</div>
			</div>
			
		</td>
          </tr>					  
      </tbody>
    </table>  
		
	</form>

<p>&nbsp;  </p>
<p>&nbsp;  </p>
 </body>
</html>
