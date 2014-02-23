<head>
	<title>private zone</title>
</head>
<body>
		<div id="User Basic Information">
		  	<table style="text-align:left;">
		  		<tr><td>个人基本信息:</td><td></td></tr>
	  			<tr><td>Nick Name:&nbsp;</td><td><c:out value="${privateZoneDTO.personalInfo.nickname }"/></tr>
	  			<tr><td>Icon:&nbsp;</td><td><c:out value="${privateZoneDTO.personalInfo.imageUrl }"/></tr>
	  			<tr><td>关注列表:</td><td></td></tr>
	  			<c:choose>
	  				<c:when test="${not empty privateZoneDTO.followShip.followerList}">
	  					<tr>
		  					<c:forEach items="${privateZoneDTO.followShip.followerList }" var="follower">
		  						<td><c:out value="${follower.nickname }"/></td>
		  						<td><c:out value="${follower.imageUrl }"/></td>
		  					</c:forEach> 
	  					</tr>
	  				</c:when>
	  				<c:otherwise>
	  					<tr><td><c:out value="欢迎参加拼团，快去关注你身边朋友的幸福之旅！"/></td><td></td></tr>
	  				</c:otherwise>
	  			</c:choose>
	  			
	  			<tr><td>喜欢列表:</td><td></td></tr>
	  			<c:choose>
	  				<c:when test="${not empty privateZoneDTO.favoriteJournalList}">
	  					<tr>
		  					<c:forEach items="${privateZoneDTO.favoriteJournalList }" var="favoriteJournal">
		  						<td><c:out value="${favoriteJournal.title }"/></td>
		  						<td><c:out value="${favoriteJournal.imageUrl }"/></td>
		  					</c:forEach> 
	  					</tr>
	  				</c:when>
	  				<c:otherwise>
	  				<tr><td><c:out value="欢迎参加拼团，请速速发表你最喜欢的日志，与你身边的朋友一起分享你的幸福旅！"/></td><td></td></tr>
	  					
	  				</c:otherwise>
	  			</c:choose>
	  			
	  			<tr><td>粉丝列表:</td><td></td></tr>
	  			<c:choose>
	  				<c:when test="${not empty privateZoneDTO.followShip.followeeList}">
	  					<tr>
		  					<c:forEach items="${privateZoneDTO.followShip.followeeList }" var="followee">
		  						<td><c:out value="${followee.nickname }"/></td>
		  						<td><c:out value="${followee.imageUrl }"/></td>
		  					</c:forEach> 
	  					</tr>
	  				</c:when>
	  				<c:otherwise>
	  				<tr><td><c:out value="欢迎参加拼团，快来和你身边的朋友分享你的幸福之旅！"/></td><td></td></tr>
	  					
	  				</c:otherwise>
	  			</c:choose>
	 
	  		</table>
		</div>
</body>

