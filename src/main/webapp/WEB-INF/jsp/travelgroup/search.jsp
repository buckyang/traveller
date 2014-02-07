<head>
	<title>搜索拼团</title>
</head>
<body>
	<form:form id="form" method="post" modelAttribute="searchTravelGroupDTO">
	  	<fieldset>
	  		<legend>搜索</legend>
	  		<form:label path="fromCity">出发城市</form:label>
	  		<form:input path="fromCity" /><br />
	  		<form:label path="arrivalCity">目的地城市</form:label>
	  		<form:input path="arrivalCity"/><br />
	  		<form:label path="beginDate">出发日期</form:label>
	  		<form:input path="beginDate"/>	  		
		</fieldset>
		<p><button type="submit">Submit</button></p>
	</form:form>
		<div id="viewContent">
			<c:forEach items="${travelGroupList}" var="travelGroup">
			  	<table>
		  			<tr><td>出发景点</td><td><c:out value="${travelGroup.fromResort }"/></tr>
		  			<tr><td>出发城市</td><td><c:out value="${travelGroup.fromCity }"/></tr>
		  			<tr><td>出发地址</td><td><c:out value="${travelGroup.fromAddress }"/></tr>
		  			<tr><td>目的地城市</td><td><c:out value="${travelGroup.arrivalCity }"/></tr>
		  			<tr><td>目的地景点</td><td><c:out value="${travelGroup.arrivalResort }"/></tr>
		  			<tr><td>出发日期</td><td><c:out value="${travelGroup.fromDate }"/></tr>
		  			<tr><td>自助游类型</td><td><c:out value="${travelGroup.type }"/></tr>
		  			<tr><td>预计天数</td><td><c:out value="${travelGroup.days }"/></tr>
		  			<tr><td>参团人数</td><td><c:out value="${fn:length(travelGroup.travelGroupAccounts) + 1 }"/>/<c:out value="${travelGroup.count }"/></tr>
		  			<tr><td>预计花费</td><td><c:out value="${travelGroup.budget }"/></tr>
		  			<tr><td>拼团主题</td><td><c:out value="${travelGroup.topic }"/></tr>
		  			<tr><td>备注</td><td><c:out value="${travelGroup.note }"/></tr>	
		  			<c:forEach items="${travelGroup.scheduleNotes }" var="scheduleNote">
		  				<tr><td>天数&nbsp;&nbsp;${scheduleNote.dayNumber}</td><td><c:out value="${scheduleNote.note}"/></tr>
		  			</c:forEach> 
		  			<tr><td colspan="2">评论</td></tr> 
		  			<c:forEach items="${travelGroup.travelGroupRemarks }" var="travelGroupRemark">
		  				<tr>
		  					<td><c:out value="${travelGroupRemark.nickname }"/>在 &nbsp;<fmt:formatDate value="${travelGroupRemark.date }" pattern="yyyy/MM/dd hh:mm:ss"/>说：</td>
		  					<td><c:out value="${travelGroupRemark.remark }"/>
		  				</tr>
		  			</c:forEach> 	  						
		  		</table>				
			</c:forEach>
  				  				  				  				  		
		</div>

</body>

