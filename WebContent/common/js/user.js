		var id_check = /[^ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789]{1}/g;
		
		// 이메일 체크
		var checkEmailValidation = function(){
			var at = '', name = '', domain = '';
			var f = document.playyLogin;
			var email = f.email.value;
			var passwd = f.passwd.value;
			
			at = email.charAt(email.indexOf('@'));
			name = email.substring(0, email.indexOf('@'));
			domain = email.substring(email.indexOf('@')+1, email.length);
			 
			if(at != '@') {
				alert('@가 없습니다.');
				onFocusValue(f.email);
				return false;
			}			    
			if(!/^([a-zA-Z0-9_\.\-])+$/.test(name)) {
				alert('이메일 주소가 잘못되었습니다.');
				onFocusValue(f.email);
				return false;
			}			    
			if(!/^(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(domain)) {
				alert('이메일 주소가 잘못되었습니다.');
				onFocusValue(f.email);
				return false;
			}			
			if(passwd == "" || passwd.length <= 0){
				alert("비밀번호를 입력하시기 바랍니다.");
				onFocusValue(f.passwd);
    			return false;
			}
			return true;
		};
		
		var checkTypeChange = function(tab, view){
			if(tab == "tab01"){
				$('#tab01').removeClass();
				$('#tab01').addClass('tab01_on');
				$('#tab02').removeClass();
				$('#tab02').addClass('tab02_off');
				$('#idLogin').show();
				$('#emailLogin').hide();
			} else {
				$('#tab01').removeClass();
				$('#tab01').addClass('tab01_off');
				$('#tab02').removeClass();
				$('#tab02').addClass('tab02_on');
				$('#idLogin').hide();
				$('#emailLogin').show();
			}
			$('#checkType').val(view);
		};
		
		// 로그인 스크립트
		var checkForm = function(){
			var f = document.playyLogin;
			var checkType = $('#checkType').val();
			
			if(checkType=="idLogin"){
				if(checkValidation()){
					f.iddomain.value = f.id.value + "@paran.com";
					f.submit();
				}
			} else{
				if(checkEmailValidation()){
					f.iddomain.value = f.email.value;
					f.submit();
				}
			}
			return;
		};


		var keyupLogin = function(){
			if(event.keyCode == 13){
				checkForm();
			}
		};
		
		// id / passwd form validation
		var checkValidation = function(){
			var f = document.playyLogin;
			var id = f.id.value;
			var passwd = f.passwd.value;


			if(id == "" || id.length <= 0 || id == "아이디"){
				alert("아이디는 반드시 입력해야 합니다. 아이디를 입력하시기 바랍니다.");
				onFocusValue(f.id);
    			return false;
			}

			if (id.indexOf(" ") != -1) {
    			alert("아이디에는 공백을 넣을 수 없습니다. 아이디를 다시 입력하시기 바랍니다.");
				onFocusValue(f.id);
                return false;
    		}


			if(id_check.test(id)){ // 영어 / 숫자만 가능
				alert("아이디는 영문자와 숫자로만 이루어져야 합니다. 아이디를 다시 입력하시기 바랍니다.");
				onFocusValue(f.id);
                return false;
			}

			if (id.length < 4 || id.length > 12) {
                alert("아이디는 4글자 이상 12글자 이하이어야 합니다. 아이디를 다시 입력하시기 바랍니다.");
				onFocusValue(f.id);
                return false;
            }


			if(passwd == "" || passwd.length <= 0){
				alert("비밀번호를 입력하시기 바랍니다.");
				onFocusValue(f.passwd);
    			return false;
			}

			return true;
		};

		var onFocusValue = function(f){
			f.value = "";
			f.focus();
		};


		// 아이디 onclick 시 아이디 이름 삭제
		var idClickToSpace = function(){
			var f = document.playyLogin;
			if(f.id.value == "아이디"){
				onFocusValue(f.id);
			}
		};
		
		// 아무것도 없거나 공백만일 때 아이디 넣어줌
		var idFocusOut = function(){
			var f = document.playyLogin;
			if(jQuery.trim(f.id.value) == ""){
				f.id.value = "아이디";
			}
		};

		// 아이디 onclick 시 비밀번호 삭제
		var passwdClickToSpace = function(){

			var f = document.playyLogin;
			if(jQuery.trim(f.passwd.value) == ""){
				//f.passwd.type = "password";
				onFocusValue(f.passwd);
				$('.txt-pass').empty();
			}
		};

		// 아무것도 없거나 공백만일 때 다시 비밀번호 넣어줌
		var passwdFocusOut = function(){
			var f = document.playyLogin;
			if(jQuery.trim(f.passwd.value) == ""){
				f.passwd.value = "";
				$('.txt-pass').text('비밀번호');
			}
		};

		// 로그인 스크립트





