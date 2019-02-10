<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

   <a href="#CaseStudyPanel" id="CaseStudyLink" data-toggle="collapse">
            <h4 class="modal-header bg-primary bg-darken-4 text-white">
                Case Study
                <span style="float:right">
                    <i class="fas fa-chevron-circle-down" style="color:rgb(0, 0, 0)"></i>
                </span>
            </h4>
        </a>
        <div class="modal-body animate fade-in collapse in " id="CaseStudyPanel">
                <div class="row">
                        <div class="col-md-4 form-group">
                            <label> Profile of Client<span class="text-danger">*</span> </label>
                            <input type="file" id="fileProfile" onfocus="RemoveClass(this.id);" onblur="ValidRequiredField(this.id);" onkeypress="return OnKeyBlockForName(event)" class="form-control border-red animated shake">
                        </div>
                        <div class="col-md-4 form-group">
                            <label>Obligation Sheet<span class="text-danger">*</span> </label>
                            <input type="text" id="txtOS" placeholder="Enter Obligation Sheet  " onfocus="RemoveClass(this.id);" onblur="ValidRequiredField(this.id);" onkeypress="return OnKeyBlockForName(event)" class="form-control border-red animated shake">
                            <input type="file" id="fileObligation" onfocus="RemoveClass(this.id);" onblur="ValidRequiredField(this.id);" onkeypress="return OnKeyBlockForName(event)" class="form-control border-red animated shake">
                        </div>
                        <div class="col-md-4 form-group">
                            <label>Eligibility calculation sheet<span class="text-danger">*</span> </label>
                            <input type="text" id="txtECS" placeholder="Enter Eligibility calculation sheet " onfocus="RemoveClass(this.id);" onblur="ValidRequiredField(this.id);" onkeypress="return OnKeyBlockForName(event)" class="form-control border-red animated shake">
                            <input type="file" id="fileEligibility" onfocus="RemoveClass(this.id);" onblur="ValidRequiredField(this.id);" onkeypress="return OnKeyBlockForName(event)" class="form-control border-red animated shake" />
                        </div>
                    </div>
        </div>


</body>
</html>