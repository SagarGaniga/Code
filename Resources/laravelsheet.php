Excel::create('sagar', function($excel){
	$excel->sheet('sheetname', function($sheet){
		$disc = \App\Discussion::all();
		$sheet-> fromModel($disc);

	});
})->download('xls');
