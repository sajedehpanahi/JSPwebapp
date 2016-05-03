function addRow() {

    var conditionName = document.getElementById("conditionName");
    var minDuration = document.getElementById("minDuration");
    var maxDuration = document.getElementById("maxDuration");
    var minAmount = document.getElementById("minAmount");
    var maxAmount = document.getElementById("maxAmount");
    var table = document.getElementById("grantConditionsTable");

    var rowCount = table.rows.length;
    if (rowCount == 0) {
        var headerRow = table.insertRow(rowCount);
        var headerCell = document.createElement("TH");
        headerCell.innerHTML = "ردیف";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("TH");
        headerCell.innerHTML = "نام شرط";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداقل مدت قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداکثر مدت قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداقل مبلغ قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("TH");
        headerCell.innerHTML = "حداکثر مبلغ قرارداد";
        headerRow.appendChild(headerCell);
        headerCell = document.createElement("TH");
        headerCell.innerHTML = "عملیات";
        headerRow.appendChild(headerCell);
        rowCount++;

    }
    var row = table.insertRow(rowCount);
    row.insertCell(0).innerHTML = (rowCount).toString();
    row.insertCell(1).innerHTML = conditionName.value;
    row.insertCell(2).innerHTML = minDuration.value;
    row.insertCell(3).innerHTML = maxDuration.value;
    row.insertCell(4).innerHTML = minAmount.value;
    row.insertCell(5).innerHTML = maxAmount.value;
    row.insertCell(6).innerHTML = '<button class="button" onClick="deleteRow(this)">حذف</button>';
}

function deleteRow(obj) {

    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("grantConditionsTable");
    table.deleteRow(index);
    var rowCount = table.rows.length;
    if(rowCount==1){
        table.deleteTHead();
        /*TODO delet headers*/
    }else{
        for(var i =1;i<=rowCount;i++){
            table.rows[i].cells[0].innerHTML =i.toString();
        }
    }

}
