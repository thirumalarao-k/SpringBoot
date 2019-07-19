<%@ include file="masheader.jsp" %>  
<p>&nbsp;  </p>
<p>&nbsp;  </p>
<p>&nbsp;  </p>
  <!-- /.container-fluid -->
<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody>
         <tr>
            <td colspan="2" align="center">
			<div class="panel panel-success">
      <div class="panel-heading"><Strong>Configure Micro Service For Allianz Rest Service Application</Strong></div>
    </div>
				<form method="post" action="/masstudio/generateMicroService2">
				 <table class = "table table-hover text-centered">
    
   <thead >
      <tr>
         <th >S.No</th>
         <th >Controller Name</th>
         <th >Access Points</th>
         <th >Controller Method</th>
         <th >Method Reference</th>
         <th >Sequence Flow</th>
		 <th > <label><input type="checkbox" value="">Select All</label></th>
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
		 <td><input type="checkbox" value=""></td>
      </tr>	  
	   <tr class="success">
         <td>2</td>
         <td>Catalogue Controller</td>
         <td>/getProductCatalogue</td>
         <td>listProducts</td>
         <td>getElectricals</td>
         <td>getElectronicsStores - > iterateProducts - > Convert</td>
		 <td><input type="checkbox" value=""></td>
      </tr>	  
	   <tr class="info">
         <td>3</td>
         <td>Catalogue Controller</td>
         <td>/getProductCatalogue</td>
         <td>listProducts</td>
         <td>getBooks</td>
         <td>getVendors -> checkIsAuthorized -> getAllBooks -> Consolidate </td>
		 <td><input type="checkbox" value=""></td>
      </tr>	  
      <tr class="success">
         <td>4</td>
         <td>Catalogue Controller</td>
         <td>/getProductCatalogue</td>
         <td>listProducts</td>
         <td>getGadgets</td>
         <td>getRetailers - > checkGadgets - > Consolidate 	</td>
		 <td><input type="checkbox" value=""></td>
      </tr>     
</table>
				<div class="form-group">
					<button type="button"  onClick="window.location='/masstudio/generateMicroService';" align="center" class="btn btn-success">Previous</button>
					<button type="button"  onClick="window.location='/masstudio/generateMicroService2';" align="center" class="btn btn-success">Next</button>
				</div>
				</form>
			</td>
          </tr>	
      </tbody>
    </table>  	
 </body>
</html>
