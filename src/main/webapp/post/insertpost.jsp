<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Summernote</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#summernote').summernote();
		$("#regBtn").on("click",function(){
				$("#frm").submit();
			});
		
	});
</script>
<style type="text/css">
textarea {
	width: 500px;
	height: 100px;
	resize: none;
}
#dd{
margin-top:100px; 
}
</style>
</head>
<body>

	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">

					<div class="col-sm-8 blog-main">
					<div id="dd"></div>
						<form method="post" action="${cp}/insertPost" id="frm" enctype="multipart/form-data">
					<label for="post_title" class="col-sm-2 control-label">제목</label>
							<input style="width: 800px;" type="text" id="post_title" name="post_title"></input><br>
							<input type="text" id="board_id" name="board_id" hidden="hidden" value="${board_id}"></input>
							<textarea id="summernote" name="post_content"></textarea>
							
						<div>
						
							<input type="file" id="realFilename1" name="realFilename1" >첨부파일1
							<input type="file" id="realFilename2" name="realFilename2" >첨부파일2
							<input type="file" id="realFilename3" name="realFilename3" >첨부파일3
							<input type="file" id="realFilename4" name="realFilename4" >첨부파일4
							<input type="file" id="realFilename5" name="realFilename5" >첨부파일5
						</div>
							<button type="button" class="btn btn-default" id="regBtn">등록</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>