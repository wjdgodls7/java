<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
td, th {
	text-align: center;
}
</style>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>회원정보 수정 화면</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<!-- Favicons -->

<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/table.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: WeBuild - v2.1.0
  * Template URL: https://bootstrapmade.com/free-bootstrap-coming-soon-template-countdwon/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
	<!-- ======= Header ======= -->
	<header id="header" style="padding: auto;">
		<div class="container-fluid">

			<div class="logo float-left">
				<h1 class="text-light">
					<a href="index.html"><span
						style="font-size: 35px; font-weight: bold;">ICIA</span></a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>

			<div class="contact-link float-right">
				<a href="#contact" class="scrollto"
					style="font-size: 35px; font-weight: bold;">ABOUT</a>
			</div>

		</div>
	</header>
	<!-- End #header -->

	<!-- ======= Hero Section ======= -->
	<section id="hero">
		<div class="hero-container">
			<div class="countdown" data-count="2021/3/2"
				data-template="Until the day of completion<br/> %w weeks %d days <br> %H:%M:%S"></div>
			 
			<form action="memberModify">
				<div class="row no-gutters">

					<table>
						<tr>
							<td>회원 ID</td>
							<td>${id}
							<input	type="hidden" value="${id}" name="id"></td>
						</tr>

						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password" maxlength="15"
								placeholder="비밀번호(8~15자리)"></td>
						</tr>

						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" name="passwordcheck"
								maxlength="15" placeholder="비밀번호 재입력"></td>
						</tr>

						<tr>
							<td>이름</td>
							<td><input type="text" name="name" maxlength="6"
								autocomplete="off"></td>
						</tr>

						<tr>
							<td>닉네임</td>
							<td><input type="text" name="nick" maxlength="20"
								placeholder="닉네임을 입력해주세요." autocomplete="off"> <input
								type="button" value="중복확인"></td>
						</tr>

						<tr>
							<td>성별</td>
							<td><input type="radio" name="gender" value="남자">남자
								<input type="radio" name="gender" value="여자">여자</td>
						</tr>

						<tr>
							<td>조</td>
							<td><select name="team">
									<option value="">조</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
							</select></td>
						</tr>

						<tr>
							<td>생년월일</td>
							<td><input type="text" name="birthyy" maxlength="4"
								placeholder="년(4자)" size="6"> <select name="birthmm">
									<option value="">월</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select> <input type="text" name="birthdd" maxlength="2" placeholder="일"
								size="4"></td>
						</tr>

						<tr>
							<td>이메일</td>
							<td><input type="text" name="email" maxlength="15"
								autocomplete="off">@ <select name="email2">
									<option>naver.com</option>
									<option>daum.net</option>
									<option>gmail.com</option>
									<option>nate.com</option>
							</select></td>
						</tr>

						<tr>
							<td>휴대전화</td>
							<td><input type="text" name="phone" maxlength="11"
								autocomplete="off" placeholder="-제외하고 작성해주세요"></td>
						</tr>

						<tr>
							<td>주소</td>
							<td><input type="text" id="sample6_postcode"
								placeholder="우편번호" name="add"> <input type="button"
								onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" id="sample6_address" placeholder="주소"><br>
								<input type="text" id="sample6_detailAddress" placeholder="상세주소">
								<input type="text" id="sample6_extraAddress" placeholder="참고항목">

								<script
									src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
								<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script></td>
						</tr>

						<tr>
							<td colspan="2" style="text-align: right;"><input
								type="submit" value="수정하기"></td>
						</tr>

					</table>

				</div>
			</form>
		</div>
	</section>

</body>
</html>