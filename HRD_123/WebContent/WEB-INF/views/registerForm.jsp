<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/common/header.jsp" %>

	<section>
		<h2>쇼핑몰 회원 등록</h2>
		
		<table align="center">
			<tr>
				<td>회원번호(자동발생)</td>
				<td><input type='text' name='member_num' value="" readonly="readonly" ></td>
			</tr>
			<tr>
				<td>회원성명 </td>
				<td><input type='text' name='member_name' required ></td>
			</tr>
			<tr>
				<td>회원전화 </td>
				<td><input type='text' name='member_phone' ></td>
			</tr>
			<tr>
				<td>회원주소 </td>
				<td><input type='text' name='member_address' ></td>
			</tr>
			<tr>
				<td>가입일자 </td>
				<td><input type='text' name='member_join_date' value=""></td>
			</tr>
			<tr>
				<td>고객등급[A:VIP,B=일반,C:직원] </td>
				<td><input type='text' name='member_title' ></td>
			</tr>
			<tr>
				<td>도시코드 </td>
				<td><input type='text' name='member_city' ></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="reg_button" type="button"  >등록</button>
					<button id="list_button" type="button"  >조회</button> 
				</td>
				
			</tr>
		</table>
		
	</section>
	
<%@ include file="/common/footer.jsp" %>