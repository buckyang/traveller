<head>
	<title>用户更新</title>
</head>
<body>
	<div id="formsContent">
		<h2>用户更新</h2>
		<form:form id="form" method="post" modelAttribute="updateAccountDTO">
			<div class="header">
		  		<c:if test="${not empty message}">
					<div id="message" class="success"><s:message code="${message}"/></div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">输入信息有误</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>注册</legend>
		  		<form:label path="email">电子邮箱</form:label><c:out value="${profile.email }"></c:out><br />
		  		<form:label path="realName">真实姓名</form:label>
		  		<form:input path="realName" /><form:errors path="realName" cssClass="error" /><br />	
		  		<form:label path="sex">性别</form:label>
		  		<form:select path="sex" >
		  			<form:option value="0">男</form:option>
		  			<form:option value="1">女</form:option>
				</form:select>		  			
		  		<form:errors path="sex" cssClass="error" /><br />
		  		<form:label path="phone">电话</form:label>
		  		<form:input path="phone" /><form:errors path="phone" cssClass="error" /><br />
		  		<form:label path="nickname">昵称</form:label>
		  		<form:input path="nickname" /><form:errors path="nickname" cssClass="error" /><br />		
		  		<form:label path="idNumber">身份证编号</form:label>
		  		<form:input path="idNumber" /><form:errors path="idNumber" cssClass="error" /><br />			  		  				  				  			  				  			
		  	</fieldset>
			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
</body>

