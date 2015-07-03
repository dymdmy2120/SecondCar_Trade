function checkForBrower() {
		var browser = navigator.appName;

		var b_version = navigator.appVersion;

		var version = b_version.split(";");

		alert(version[1]);
		var trim_Version = version[1].replace(/[ ]/g, "");

		if (browser == "Microsoft Internet Explorer"
				&& trim_Version == "MSIE7.0")

		{

			alert("IE 7.0");
			return 0;
		}

		else if (browser == "Microsoft Internet Explorer"
				&& trim_Version == "MSIE6.0")

		{

			alert("IE 6.0");
			return 0;
		}
	}