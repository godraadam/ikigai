console.clear();

var welcome_text = document.getElementById("welcome");
var user = JSON.parse(localStorage.getItem("user"));
var get_started_button = document.getElementById("done_button");
var svgMapDataGPD = {
	data: {
	  visited: {
		  name: 'Visited? ',
		  format: "{0}",
	  },
	  date: {
		name: 'Date:',
		format: '{0}',
		
	  },
	  description: {
		name: 'Review:',
		format: '{0}',
		
	  }
	  
	},
	applyData: 'visited',
	values: {
	  AF: {visited: "No", date: "-", description: "-"},
	  AL: {visited: "No", date: "-", description: "-"},
	  DZ: {visited: "No", date: "-", description: "-"},
	  AO: {visited: "No", date: "-", description: "-"},
	  AG: {visited: "No", date: "-", description: "-"},
	  AR: {visited: "No", date: "-", description: "-"},
	  AM: {visited: "No", date: "-", description: "-"},
	  AU: {visited: "Yes", date: "18/08/2018", description: "Don't get close to kangoroos!"},
	  AT: {visited: "No", date: "-", description: "-"},
	  AZ: {visited: "No", date: "-", description: "-"},
	  BS: {visited: "No", date: "-", description: "-"},
	  BH: {visited: "No", date: "-", description: "-"},
	  BD: {visited: "No", date: "-", description: "-"},
	  BB: {visited: "No", date: "-", description: "-"},
	  BY: {visited: "No", date: "-", description: "-"},
	  BE: {visited: "No", date: "-", description: "-"},
	  BZ: {visited: "No", date: "-", description: "-"},
	  BJ: {visited: "No", date: "-", description: "-"},
	  BT: {visited: "No", date: "-", description: "-"},
	  BO: {visited: "No", date: "-", description: "-"},
	  BA: {visited: "No", date: "-", description: "-"},
	  BW: {visited: "No", date: "-", description: "-"},
	  BR: {visited: "No", date: "-", description: "-"},
	  BN: {visited: "No", date: "-", description: "-"},
	  BG: {visited: "No", date: "-", description: "-"},
	  BF: {visited: "No", date: "-", description: "-"},
	  BI: {visited: "No", date: "-", description: "-"},
	  KH: {visited: "No", date: "-", description: "-"},
	  CM: {visited: "No", date: "-", description: "-"},
	  CA: {visited: "No", date: "-", description: "-"},
	  XK: {visited: "No", date: "-", description: "-"},
	  CV: {visited: "No", date: "-", description: "-"},
	  CF: {visited: "No", date: "-", description: "-"},
	  TD: {visited: "No", date: "-", description: "-"},
	  CL: {visited: "No", date: "-", description: "-"},
	  CN: {visited: "No", date: "-", description: "-"},
	  CO: {visited: "No", date: "-", description: "-"},
	  KM: {visited: "No", date: "-", description: "-"},
	  CG: {visited: "No", date: "-", description: "-"},
	  CR: {visited: "No", date: "-", description: "-"},
	  HR: {visited: "No", date: "-", description: "-"},
	  CY: {visited: "No", date: "-", description: "-"},
	  CZ: {visited: "No", date: "-", description: "-"},
	  CD: {visited: "No", date: "-", description: "-"},
	  DK: {visited: "No", date: "-", description: "-"},
	  DJ: {visited: "No", date: "-", description: "-"},
	  DM: {visited: "No", date: "-", description: "-"},
	  DO: {visited: "No", date: "-", description: "-"},
	  EC: {visited: "No", date: "-", description: "-"},
	  EG: {visited: "No", date: "-", description: "-"},
	  SV: {visited: "No", date: "-", description: "-"},
	  GQ: {visited: "No", date: "-", description: "-"},
	  ER: {visited: "No", date: "-", description: "-"},
	  EE: {visited: "No", date: "-", description: "-"},
	  ET: {visited: "No", date: "-", description: "-"},
	  FM: {visited: "No", date: "-", description: "-"},
	  FJ: {visited: "No", date: "-", description: "-"},
	  FI: {visited: "No", date: "-", description: "-"},
	  FR: {visited: "No", date: "-", description: "-"},
	  GA: {visited: "No", date: "-", description: "-"},
	  GM: {visited: "No", date: "-", description: "-"},
	  GE: {visited: "No", date: "-", description: "-"},
	  DE: {visited: "No", date: "-", description: "-"},
	  GH: {visited: "No", date: "-", description: "-"},
	  GR: {visited: "No", date: "-", description: "-"},
	  GD: {visited: "No", date: "-", description: "-"},
	  GT: {visited: "No", date: "-", description: "-"},
	  GN: {visited: "No", date: "-", description: "-"},
	  GW: {visited: "No", date: "-", description: "-"},
	  GY: {visited: "No", date: "-", description: "-"},
	  HT: {visited: "No", date: "-", description: "-"},
	  HN: {visited: "No", date: "-", description: "-"},
	  HK: {visited: "No", date: "-", description: "-"},
	  HU: {visited: "Yes", date: "11/09/2001", description: "Such a nice country."},
	  IS: {visited: "No", date: "-", description: "-"},
	  IN: {visited: "No", date: "-", description: "-"},
	  ID: {visited: "No", date: "-", description: "-"},
	  IR: {visited: "No", date: "-", description: "-"},
	  IQ: {visited: "No", date: "-", description: "-"},
	  IE: {visited: "No", date: "-", description: "-"},
	  IL: {visited: "No", date: "-", description: "-"},
	  IT: {visited: "No", date: "-", description: "-"},
	  CI: {visited: "No", date: "-", description: "-"},
	  JM: {visited: "No", date: "-", description: "-"},
	  JP: {visited: "No", date: "-", description: "-"},
	  JO: {visited: "No", date: "-", description: "-"},
	  KZ: {visited: "No", date: "-", description: "-"},
	  KE: {visited: "No", date: "-", description: "-"},
	  KI: {visited: "No", date: "-", description: "-"},
	  KW: {visited: "No", date: "-", description: "-"},
	  KG: {visited: "No", date: "-", description: "-"},
	  LA: {visited: "No", date: "-", description: "-"},
	  LV: {visited: "No", date: "-", description: "-"},
	  LB: {visited: "No", date: "-", description: "-"},
	  LS: {visited: "No", date: "-", description: "-"},
	  LR: {visited: "No", date: "-", description: "-"},
	  LY: {visited: "No", date: "-", description: "-"},
	  LT: {visited: "No", date: "-", description: "-"},
	  LU: {visited: "No", date: "-", description: "-"},
	  MO: {visited: "No", date: "-", description: "-"},
	  MK: {visited: "No", date: "-", description: "-"},
	  MG: {visited: "No", date: "-", description: "-"},
	  MW: {visited: "No", date: "-", description: "-"},
	  MY: {visited: "No", date: "-", description: "-"},
	  MV: {visited: "No", date: "-", description: "-"},
	  ML: {visited: "No", date: "-", description: "-"},
	  MT: {visited: "No", date: "-", description: "-"},
	  MH: {visited: "No", date: "-", description: "-"},
	  MR: {visited: "No", date: "-", description: "-"},
	  MU: {visited: "No", date: "-", description: "-"},
	  MX: {visited: "No", date: "-", description: "-"},
	  MD: {visited: "No", date: "-", description: "-"},
	  MN: {visited: "No", date: "-", description: "-"},
	  ME: {visited: "No", date: "-", description: "-"},
	  MA: {visited: "No", date: "-", description: "-"},
	  MZ: {visited: "No", date: "-", description: "-"},
	  MM: {visited: "No", date: "-", description: "-"},
	  NA: {visited: "No", date: "-", description: "-"},
	  NR: {visited: "No", date: "-", description: "-"},
	  NP: {visited: "No", date: "-", description: "-"},
	  NL: {visited: "No", date: "-", description: "-"},
	  NZ: {visited: "No", date: "-", description: "-"},
	  NI: {visited: "No", date: "-", description: "-"},
	  NE: {visited: "No", date: "-", description: "-"},
	  NG: {visited: "No", date: "-", description: "-"},
	  NO: {visited: "No", date: "-", description: "-"},
	  OM: {visited: "No", date: "-", description: "-"},
	  PK: {visited: "No", date: "-", description: "-"},
	  PW: {visited: "No", date: "-", description: "-"},
	  PA: {visited: "No", date: "-", description: "-"},
	  PG: {visited: "No", date: "-", description: "-"},
	  PY: {visited: "No", date: "-", description: "-"},
	  PE: {visited: "No", date: "-", description: "-"},
	  PH: {visited: "No", date: "-", description: "-"},
	  PL: {visited: "No", date: "-", description: "-"},
	  PT: {visited: "No", date: "-", description: "-"},
	  PR: {visited: "No", date: "-", description: "-"},
	  QA: {visited: "No", date: "-", description: "-"},
	  RO: {visited: "Yes", date: "always", description: "Home, sweet home."},
	  RU: {visited: "Yes", date: "12/12/2017", description: "Davai, davai"},
	  RW: {visited: "No", date: "-", description: "-"},
	  KN: {visited: "No", date: "-", description: "-"},
	  LC: {visited: "No", date: "-", description: "-"},
	  VC: {visited: "No", date: "-", description: "-"},
	  WS: {visited: "No", date: "-", description: "-"},
	  SM: {visited: "No", date: "-", description: "-"},
	  ST: {visited: "No", date: "-", description: "-"},
	  SA: {visited: "No", date: "-", description: "-"},
	  SN: {visited: "No", date: "-", description: "-"},
	  RS: {visited: "No", date: "-", description: "-"},
	  SC: {visited: "No", date: "-", description: "-"},
	  SL: {visited: "No", date: "-", description: "-"},
	  SG: {visited: "No", date: "-", description: "-"},
	  SK: {visited: "No", date: "-", description: "-"},
	  SI: {visited: "No", date: "-", description: "-"},
	  SB: {visited: "No", date: "-", description: "-"},
	  SO: {visited: "No", date: "-", description: "-"},
	  ZA: {visited: "No", date: "-", description: "-"},
	  KR: {visited: "No", date: "-", description: "-"},
	  SS: {visited: "No", date: "-", description: "-"},
	  ES: {visited: "No", date: "-", description: "-"},
	  LK: {visited: "No", date: "-", description: "-"},
	  SD: {visited: "No", date: "-", description: "-"},
	  SR: {visited: "No", date: "-", description: "-"},
	  SZ: {visited: "No", date: "-", description: "-"},
	  SE: {visited: "No", date: "-", description: "-"},
	  CH: {visited: "No", date: "-", description: "-"},
	  TW: {visited: "No", date: "-", description: "-"},
	  TJ: {visited: "No", date: "-", description: "-"},
	  TZ: {visited: "No", date: "-", description: "-"},
	  TH: {visited: "No", date: "-", description: "-"},
	  TL: {visited: "No", date: "-", description: "-"},
	  TG: {visited: "No", date: "-", description: "-"},
	  TO: {visited: "No", date: "-", description: "-"},
	  TT: {visited: "No", date: "-", description: "-"},
	  TN: {visited: "No", date: "-", description: "-"},
	  TR: {visited: "No", date: "-", description: "-"},
	  TM: {visited: "No", date: "-", description: "-"},
	  TV: {visited: "No", date: "-", description: "-"},
	  UG: {visited: "No", date: "-", description: "-"},
	  UA: {visited: "No", date: "-", description: "-"},
	  AE: {visited: "No", date: "-", description: "-"},
	  GB: {visited: "No", date: "-", description: "-"},
	  US: {visited: "No", date: "-", description: "-"},
	  UY: {visited: "No", date: "-", description: "-"},
	  UZ: {visited: "No", date: "-", description: "-"},
	  VU: {visited: "No", date: "-", description: "-"},
	  VE: {visited: "No", date: "-", description: "-"},
	  VN: {visited: "No", date: "-", description: "-"},
	  YE: {visited: "No", date: "-", description: "-"},
	  ZM: {visited: "No", date: "-", description: "-"},
	  ZW: {visited: "No", date: "-", description: "-"},
	}
  }
var stringMapping = new Map([
	['AL', svgMapDataGPD.values.AL],
	['AL', svgMapDataGPD.values.AF],
	['DZ', svgMapDataGPD.values.DZ],
	['AO', svgMapDataGPD.values.AO],
	['AG', svgMapDataGPD.values.AG],
	['AR', svgMapDataGPD.values.AR],
	['AM', svgMapDataGPD.values.AM],
	['AU', svgMapDataGPD.values.AU],
	['AT', svgMapDataGPD.values.AT],
	['AZ', svgMapDataGPD.values.AZ],
	['BS', svgMapDataGPD.values.BS],
	['BH', svgMapDataGPD.values.BH],
	['BD', svgMapDataGPD.values.BD],
	['BB', svgMapDataGPD.values.BB],
	['BY', svgMapDataGPD.values.BY],
	['BE', svgMapDataGPD.values.BE],
	['BZ', svgMapDataGPD.values.BZ],
	['BJ', svgMapDataGPD.values.BJ],
	['BT', svgMapDataGPD.values.BT],
	['BO', svgMapDataGPD.values.BO],
	['BA', svgMapDataGPD.values.BA],
	['BW', svgMapDataGPD.values.BW],
	['BR', svgMapDataGPD.values.BR],
	['BN', svgMapDataGPD.values.BN],
	['BG', svgMapDataGPD.values.BG],
	['BF', svgMapDataGPD.values.BF],
	['BI', svgMapDataGPD.values.BI],
	['KH', svgMapDataGPD.values.KH],
	['CM', svgMapDataGPD.values.CM],
	['CA', svgMapDataGPD.values.CA],
	['XK', svgMapDataGPD.values.XK],
	['CV', svgMapDataGPD.values.CV],
	['CF', svgMapDataGPD.values.CF],
	['TD', svgMapDataGPD.values.TD],
	['CL', svgMapDataGPD.values.CL],
	['CN', svgMapDataGPD.values.CN],
	['CO', svgMapDataGPD.values.CO],
	['KM', svgMapDataGPD.values.KM],
	['CG', svgMapDataGPD.values.CG],
	['CR', svgMapDataGPD.values.CR],
	['HR', svgMapDataGPD.values.HR],
	['CY', svgMapDataGPD.values.CY],
	['CZ', svgMapDataGPD.values.CZ],
	['CD', svgMapDataGPD.values.CD],
	['DK', svgMapDataGPD.values.DK],
	['DJ', svgMapDataGPD.values.DJ],
	['DM', svgMapDataGPD.values.DM],
	['DO', svgMapDataGPD.values.DO],
	['EC', svgMapDataGPD.values.EC],
	['EG', svgMapDataGPD.values.EG],
	['SV', svgMapDataGPD.values.SV],
	['GQ', svgMapDataGPD.values.GQ],
	['ER', svgMapDataGPD.values.ER],
	['EE', svgMapDataGPD.values.EE],
	['ET', svgMapDataGPD.values.ET],
	['FM', svgMapDataGPD.values.FM],
	['FJ', svgMapDataGPD.values.FJ],
	['FI', svgMapDataGPD.values.FI],
	['FR', svgMapDataGPD.values.FR],
	['GA', svgMapDataGPD.values.GA],
	['GM', svgMapDataGPD.values.GM],
	['GE', svgMapDataGPD.values.GE],
	['DE', svgMapDataGPD.values.DE],
	['GH', svgMapDataGPD.values.GH],
	['GR', svgMapDataGPD.values.GR],
	['GD', svgMapDataGPD.values.GD],
	['GT', svgMapDataGPD.values.GT],
	['GN', svgMapDataGPD.values.GN],
	['GW', svgMapDataGPD.values.GW],
	['GY', svgMapDataGPD.values.GY],
	['HT', svgMapDataGPD.values.HT],
	['HN', svgMapDataGPD.values.HN],
	['HK', svgMapDataGPD.values.HK],
	['HU', svgMapDataGPD.values.HU],
	['IS', svgMapDataGPD.values.IS],
	['IN', svgMapDataGPD.values.IN],
	['ID', svgMapDataGPD.values.ID],
	['IR', svgMapDataGPD.values.IR],
	['IQ', svgMapDataGPD.values.IQ],
	['IE', svgMapDataGPD.values.IE],
	['IL', svgMapDataGPD.values.IL],
	['IT', svgMapDataGPD.values.IT],
	['CI', svgMapDataGPD.values.CI],
	['JM', svgMapDataGPD.values.JM],
	['JP', svgMapDataGPD.values.JP],
	['JO', svgMapDataGPD.values.JO],
	['KZ', svgMapDataGPD.values.KZ],
	['KE', svgMapDataGPD.values.KE],
	['KI', svgMapDataGPD.values.KI],
	['KW', svgMapDataGPD.values.KW],
	['KG', svgMapDataGPD.values.KG],
	['LA', svgMapDataGPD.values.LA],
	['LV', svgMapDataGPD.values.LV],
	['LB', svgMapDataGPD.values.LB],
	['LS', svgMapDataGPD.values.LS],
	['LR', svgMapDataGPD.values.LR],
	['LY', svgMapDataGPD.values.LY],
	['LT', svgMapDataGPD.values.LT],
	['LU', svgMapDataGPD.values.LU],
	['MO', svgMapDataGPD.values.MO],
	['MK', svgMapDataGPD.values.MK],
	['MG', svgMapDataGPD.values.MG],
	['MW', svgMapDataGPD.values.MW],
	['MY', svgMapDataGPD.values.MY],
	['MV', svgMapDataGPD.values.MV],
	['ML', svgMapDataGPD.values.ML],
	['MT', svgMapDataGPD.values.MT],
	['MH', svgMapDataGPD.values.MH],
	['MR', svgMapDataGPD.values.MR],
	['MU', svgMapDataGPD.values.MU],
	['MX', svgMapDataGPD.values.MX],
	['MD', svgMapDataGPD.values.MD],
	['MN', svgMapDataGPD.values.MN],
	['ME', svgMapDataGPD.values.ME],
	['MA', svgMapDataGPD.values.MA],
	['MZ', svgMapDataGPD.values.MZ],
	['MM', svgMapDataGPD.values.MM],
	['NA', svgMapDataGPD.values.NA],
	['NR', svgMapDataGPD.values.NR],
	['NP', svgMapDataGPD.values.NP],
	['NL', svgMapDataGPD.values.NL],
	['NZ', svgMapDataGPD.values.NZ],
	['NI', svgMapDataGPD.values.NI],
	['NE', svgMapDataGPD.values.NE],
	['NG', svgMapDataGPD.values.NG],
	['NO', svgMapDataGPD.values.NO],
	['OM', svgMapDataGPD.values.OM],
	['PK', svgMapDataGPD.values.PK],
	['PW', svgMapDataGPD.values.PW],
	['PA', svgMapDataGPD.values.PA],
	['PG', svgMapDataGPD.values.PG],
	['PY', svgMapDataGPD.values.PY],
	['PE', svgMapDataGPD.values.PE],
	['PH', svgMapDataGPD.values.PH],
	['PL', svgMapDataGPD.values.PL],
	['PT', svgMapDataGPD.values.PT],
	['PR', svgMapDataGPD.values.PR],
	['QA', svgMapDataGPD.values.QA],
	['RO', svgMapDataGPD.values.RO],
	['RU', svgMapDataGPD.values.RU],
	['RW', svgMapDataGPD.values.RW],
	['KN', svgMapDataGPD.values.KN],
	['LC', svgMapDataGPD.values.LC],
	['VC', svgMapDataGPD.values.VC],
	['WS', svgMapDataGPD.values.WS],
	['SM', svgMapDataGPD.values.SM],
	['ST', svgMapDataGPD.values.ST],
	['SA', svgMapDataGPD.values.SA],
	['SN', svgMapDataGPD.values.SN],
	['RS', svgMapDataGPD.values.RS],
	['SC', svgMapDataGPD.values.SC],
	['SL', svgMapDataGPD.values.SL],
	['SG', svgMapDataGPD.values.SG],
	['SK', svgMapDataGPD.values.SK],
	['SI', svgMapDataGPD.values.SI],
	['SB', svgMapDataGPD.values.SB],
	['SO', svgMapDataGPD.values.SO],
	['ZA', svgMapDataGPD.values.ZA],
	['KR', svgMapDataGPD.values.KR],
	['SS', svgMapDataGPD.values.SS],
	['ES', svgMapDataGPD.values.ES],
	['LK', svgMapDataGPD.values.LK],
	['SD', svgMapDataGPD.values.SD],
	['SR', svgMapDataGPD.values.SR],
	['SZ', svgMapDataGPD.values.SZ],
	['SE', svgMapDataGPD.values.SE],
	['CH', svgMapDataGPD.values.CH],
	['TW', svgMapDataGPD.values.TW],
	['TJ', svgMapDataGPD.values.TJ],
	['TZ', svgMapDataGPD.values.TZ],
	['TH', svgMapDataGPD.values.TH],
	['TL', svgMapDataGPD.values.TL],
	['TG', svgMapDataGPD.values.TG],
	['TO', svgMapDataGPD.values.TO],
	['TT', svgMapDataGPD.values.TT],
	['TN', svgMapDataGPD.values.TN],
	['TR', svgMapDataGPD.values.TR],
	['TM', svgMapDataGPD.values.TM],
	['TV', svgMapDataGPD.values.TV],
	['UG', svgMapDataGPD.values.UG],
	['UA', svgMapDataGPD.values.UA],
	['AE', svgMapDataGPD.values.AE],
	['GB', svgMapDataGPD.values.GB],
	['US', svgMapDataGPD.values.US],
	['UY', svgMapDataGPD.values.UY],
	['UZ', svgMapDataGPD.values.UZ],
	['VU', svgMapDataGPD.values.VU],
	['VE', svgMapDataGPD.values.VE],
	['VN', svgMapDataGPD.values.VN],
	['YE', svgMapDataGPD.values.YE],
	['ZM', svgMapDataGPD.values.ZM],
	['ZW', svgMapDataGPD.values.ZW]])


welcome_text.innerHTML = "Welcome " + user.userName + ".";


function httpGet(theUrl, entries)
{
    var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send(JSON.stringify(entries));
	
	return xmlHttp.responseText;
}

function httpPost(theUrl, entries)
{
	var xmlHttp = new XMLHttpRequest();
	
	xmlHttp.open( 'POST', theUrl, false ); // false for synchronous request
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.send(JSON.stringify(entries));
	
    return xmlHttp.responseText;
}

var HttpClient = function() {
	this.get = function(aUrl, aCallback) {
		var anHttpRequest = new XMLHttpRequest();
		anHttpRequest.onreadystatechange = function() { 
			if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
				aCallback(anHttpRequest.responseText);
		}
  
		anHttpRequest.open( "GET", aUrl, true );            
		anHttpRequest.send( null );
	}
	this.post = function(aUrl, aCallback) {
	  var anHttpRequest = new XMLHttpRequest();
	  anHttpRequest.onreadystatechange = function() { 
		  if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
			  aCallback(anHttpRequest.responseText);
	  }
  
	  anHttpRequest.open( "POST", aUrl, true );            
	  anHttpRequest.send( null );
  }
}
  
var client = new HttpClient();
var host = 'http://127.0.0.1:8080/api';

const button = document.getElementById('add-button');
const country = document.getElementById('country');
const description = document.getElementById("description");
const searchButton = document.getElementById("searchButton");
const searchedUser = document.getElementById("searchBar");

function refreshMap(){

	if(user != null) {
		let responseGet = httpGet(host + '/user/name/' + user.userName);
		//console.log(responseGet);
		var object = JSON.parse(responseGet);
		var str = object.visits.reverse()[0].country;
		stringMapping.get(str).visited = "Yes";


		document.getElementById('description').value = svgMapDataGPD.values.RU.visited;
	}
}
if(button!=null)
button.addEventListener('click', (e) => {
	var country_var = country.value;
	var description_var = description.value;
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = today.getFullYear();
	today = mm + '/' + dd + '/' + yyyy;
	


	//if(date_var[2]!="/" && date_var[5]!="/" && date_var.length != 10){
		var entries = {country: country_var, description: description_var, date: today};
		let response = httpPost(host + '/user/visit/' + user.userName, entries);

		if(response.localeCompare("OK")){
			console.log("ok");
			refreshMap();
		}
		else console.log("bad");
		
	//}
	//document.getElementById('start').value = "";
	//document.getElementById('description').value = "";
});
if(searchButton!=null)
searchButton.addEventListener('click', (e) => {
	var search_username = searchedUser.value;
	document.getElementById('description').value = "--"+search_username;
	if(search_username != null) {
		console.log(search_username);
		let responseSearch = httpGet(host + '/user/name/' + search_username);
		console.log(responseSearch);
			if(response != []) {
				localStorage.setItem("search_user", responseSearch);
				window.location.href = '../html/other_user.html';
		}
	}
	//document.getElementById('login-username').value = "";
});

