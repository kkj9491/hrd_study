<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/header.jsp"%>

<section>
	<h2>쇼핑몰 회원 등록</h2>

	<form id='reg_form' action='/HRD_123/register' method="post">

		<table align="center">
			<tr>
				<td>회원번호(자동발생)</td>
				<td><input type='text' name='member_num' value="${id }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input id='mem_name' type='text' name='member_name' placeholder="Enter name..." required ></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><input type='text' name='member_phone'></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type='text' name='member_address'></td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type='text' name='member_join_date'
					value="${today }"></td>
			</tr>
			<tr>
				<td>고객등급[A:VIP,B=일반,C:직원]</td>
				<td><input type='text' name='member_title'></td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type='text' name='member_city'></td>
			</tr>
			<tr>
				<td colspan="2">
					<input id="reg_button" type="submit" onclick="register()" value="등록">
					<button id="list_button" type="button" onclick="list()">조회</button>
				</td>

			</tr>
		</table>
	</form>
</section>

<script>
	var request;
	
	function register() {
		console.log("register called.");
		
		if (name_validate() === false) {
			return;
		}
		
		/* var doc_root = '${pageContext.request.contextPath}';
		var formObj = document.getElementById('reg_form');
		formObj.action = doc_root + '/register';
		formObj.submit(); */
		
		request = new XMLHttpRequest();
		var url = "${pageContext.request.contextPath}/register";
		
		try {
			request.onreadystatechange = getResult;
			request.open("POST", url, true);
			request.send();
		} catch (e) {
			alert("서버로 요청이 실패");
		}
	}
	
	function getResult() {
		if (request.readyState == 4) {
			var result = request.responseText;
			
			if (result === '0') {
				alert('회원등록이 완료되었습니다');
			} else {
				alert('회원등록이 실패하였습니다');
			}
		}
	}
	
	function list() {
		console.log("list called.");
	}
	
	function name_validate() {
		var input_name = document.getElementById('mem_name');
		
		if (input_name.value === '') {
			alert('회원성명이 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
</script>
<%@ include file="/common/footer.jsp"%>