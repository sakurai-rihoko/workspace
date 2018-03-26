//botton of addTemplate

$(document).ready(function() {
	$("button#addNewTemplate").click(function() {
		/* Act on the event */
		$("div#tableBox").toggle();
		$("div#addBox").toggle();


	});
});


$(document).ready(function() {
	$("button#returnTemplateTable").click(function() {
		/* Act on the event */
		$("div#tableBox").toggle();
		$("div#addBox").toggle();

		

	});
});

//botton of add Customer
$(document).ready(function() {
$('button#addNewCustomer').click(function(event) {
	$('div#CustomerTableView').toggle();
	$('div#addCustomerView').toggle();
 });
});
$(document).ready(function() {
$('button#returnToCustomerTable').click(function(event) {
	$('div#CustomerTableView').toggle();
	$('div#addCustomerView').toggle();
 });
});

//botton of add new Contract
$(document).ready(function() {
$('button[name = addNewContract]').click(function(event) {
	$('div[name = ContractTableView]').toggle();
	$('div[name = addContractView]').toggle();
 });
});
$(document).ready(function() {
$('button[name = returnToContractTable]').click(function(event) {
	$('div[name = ContractTableView]').toggle();
	$('div[name = addContractView]').toggle();
 });
});

//radio choose form
$(document).ready(function() {
	$(":radio").click(function(event) {
		/* Act on the event */
		$('form#enterprise').toggle();
		$('form#person').toggle();
	});
});


//图片上传
$(document).ready(function() {
	$('img#societyCodePic').click(function(event) {
		$('input#societyCode').click();
	});
});

$(document).ready(function() {
	$('img#IDCard-frontPic01').click(function(event) {
		$('input#IDCard-front01').click();
	});
});

$(document).ready(function() {
	$('img#IDCard-backPic01').click(function(event) {
		$('input#IDCard-back01').click();
	});
});

$(document).ready(function() {
	$('img#IDCard-frontPic02').click(function(event) {
		$('input#IDCard-front02').click();
	});
});

$(document).ready(function() {
	$('img#IDCard-backPic02').click(function(event) {
		$('input#IDCard-back02').click();
	});
});


function previewImage(file){
          var div = document.getElementById("imgPreview");
          var file = this.file[0]?this.files[0]:null;
          if (null==file) {
            return false;
          }
          var reader = new FileReader();
          reader.onload = function(){
              img.src =this.result;
          }
          reader.readAsDataURL(file.files[0]);
         }