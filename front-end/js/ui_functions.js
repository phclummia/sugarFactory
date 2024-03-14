var uiFunctions = {

  config: {},
  init: function () {
    uiFunctions.config.api = Window.apiEndPoints;

  },
  initPortfolio: function () {
    $('#customerPortfolio').hide();
  },
  getPortfolioClicked: function () {

    uiFunctions.config.api.getCustomerPortfolio(
        $('#customerNumber').val(), uiFunctions.getPortfolio);
  },
  showHistoricalData: function () {

    $('#dataTableHistorySummary').DataTable({
      bAutoWidth: false,
      data: uiFunctions.config.data.customerBucketDetailEntities[3].productBucketEntity.productBucketPerformanceDetailAgressiveEntity,
      columns: [
        {data: 'stock1Name', title: 'First Stock'},
        {data: 'stock2Name', title: 'Second Stock'},
        {data: 'stock3Name', title: 'Third Stock'},
        {data: 'mon100EFT', title: '100 EFT'},
        {data: 'unit_mon100eft', title: 'Unit 100 EFT'},
        {data: 'stockPrice', title: 'Stock Price'},
        {data: 'totalPrice', title: 'Total Price'},
        {data: 'date', title: 'Date'}]
    });

    $('#myModal').modal('show');

  },
  getPortfolio: function (data) {

    uiFunctions.config.data = data;

    $('#customerId').html(data.customerId);
    $('#customerName').html(data.name);
    let i = 0;
    for (const element of data.customerBucketDetailEntities) {
      i++;
      uiFunctions.addAccordion(i, element.productBucketEntity.productBucketId,
          element.productBucketEntity.productBucketName,
          element.productBucketEntity.productBucketDetailEntities,
          element.productBucketEntity.value,
          element.productBucketEntity.numberOfUnit);

    }

    $('#customerPortfolio').show();

  },
  initProducts: function () {
    uiFunctions.getProducts();
  },
  closeModalClicked: function () {
    $('#dataTableSummary').empty();
    $('#myModal').modal('hide');
  },
  swapEurView: function () {
    $('#percentage').hide();
    $('#ineur').show();
  },
  swapPercentageView: function () {
    $('#percentage').show();
    $('#ineur').hide();
  },
  buySafeClicked: function () {

    uiFunctions.config.api.getCustomerPortfolio(
        $('#customerNumber').val(), function (data) {
          uiFunctions.config.customerData = data;
          $('#ineur').hide();

          $('#customerName').text(uiFunctions.config.customerData.name);
          $('#packageName').text("Safe Package");
          $('#transactionDate').text((new Date()).toLocaleDateString('en-GB'));
          $('#packageFee').text("1%");
          $('#packageFeeInEur').text(($('#safeAmount').val() * 0.01) + " €");
          $('#amount').text($('#safeAmount').val());
          $('#unitToBuy').text(($('#safeAmount').val() / 4));

          $('#dataTableSummary').DataTable({
            bAutoWidth: false,
            bDestroy: true,
            data: uiFunctions.config.data[0].productBucketDetailEntities,
            columns: [
              {data: 'stockEntity.stockId', title: 'Stock Code'},
              {data: 'stockEntity.marketCap', title: 'Market Cap'},
              {data: 'stockPrice', title: 'Stock Price'},
              {data: 'unit', title: 'Unit'}]
          });

          uiFunctions.config.transactionData = {
            customerNumber: data.customerId,
            amount: $('#safeAmount').val(),
            packageId: uiFunctions.config.data[0].productBucketId
          }

          $('#myModal').modal('show');
        });

  },
  buyModerateClicked: function () {

    uiFunctions.config.api.getCustomerPortfolio(
        $('#customerNumber').val(), function (data) {
          uiFunctions.config.customerData = data;
          $('#ineur').hide();

          $('#customerName').text(uiFunctions.config.customerData.name);
          $('#packageName').text("Moderate Package");
          $('#transactionDate').text((new Date()).toLocaleDateString('en-GB'));
          $('#packageFee').text("1%");
          $('#packageFeeInEur').text(
              ($('#moderateAmount').val() * 0.01) + " €");
          $('#amount').text($('#moderateAmount').val());
          $('#unitToBuy').text(($('#moderateAmount').val() / 4));

          $('#dataTableSummary').DataTable({
            bAutoWidth: false,
            bDestroy: true,
            data: uiFunctions.config.data[0].productBucketDetailEntities,
            columns: [
              {data: 'stockEntity.stockId', title: 'Stock Code'},
              {data: 'stockEntity.marketCap', title: 'Market Cap'},
              {data: 'stockPrice', title: 'Stock Price'},
              {data: 'unit', title: 'Unit'}]
          });

          uiFunctions.config.transactionData = {
            customerNumber: data.customerId,
            amount: $('#moderateAmount').val(),
            packageId: uiFunctions.config.data[1].productBucketId
          }

          $('#myModal').modal('show');
        });

  },
  buyAggressiveClicked: function () {

    uiFunctions.config.api.getCustomerPortfolio(
        $('#customerNumber').val(), function (data) {
          uiFunctions.config.customerData = data;
          $('#ineur').hide();

          $('#customerName').text(uiFunctions.config.customerData.name);
          $('#packageName').text("Aggressive Package");
          $('#transactionDate').text((new Date()).toLocaleDateString('en-GB'));
          $('#packageFee').text("1%");
          $('#packageFeeInEur').text(
              ($('#aggressiveAmount').val() * 0.01) + " €");
          $('#amount').text($('#aggressiveAmount').val());
          $('#unitToBuy').text(($('#aggressiveAmount').val() / 4));

          $('#dataTableSummary').DataTable({
            bAutoWidth: false,
            bDestroy: true,
            data: uiFunctions.config.data[0].productBucketDetailEntities,
            columns: [
              {data: 'stockEntity.stockId', title: 'Stock Code'},
              {data: 'stockEntity.marketCap', title: 'Market Cap'},
              {data: 'stockPrice', title: 'Stock Price'},
              {data: 'unit', title: 'Unit'}]
          });

          uiFunctions.config.transactionData = {
            customerNumber: data.customerId,
            amount: $('#aggressiveAmount').val(),
            packageId: uiFunctions.config.data[2].productBucketId
          }

          $('#myModal').modal('show');
        });

  },
  completeTransaction: function () {
    $('#myModal').modal('hide');
    $('#successfulDoneModal').modal('show');
    $('#transactionData').html(
        JSON.stringify(uiFunctions.config.transactionData, null, '\t'))

  },
  closeSuccess: function () {
    $('#successfulDoneModal').modal('hide');

  },
  getProducts: function (data) {

    uiFunctions.config.api.getProducts(
        function (data) {
          uiFunctions.config.data = data;

          // Package #1
          $('#dataTableSafe').DataTable({
            bAutoWidth: false,
            data: data[0].productBucketDetailEntities,
            columns: [
              {data: 'stockEntity.stockId', title: 'Stock Code'},
              {data: 'stockEntity.marketCap', title: 'Market Cap'},
              {data: 'stockPrice', title: 'Stock Price'},
              {data: 'unit', title: 'Unit'}]
          });

          // Package #2
          $('#dataTableModerate').DataTable({
            bAutoWidth: false,
            data: data[1].productBucketDetailEntities,
            columns: [
              {data: 'stockEntity.stockId', title: 'Stock Code'},
              {data: 'stockEntity.marketCap', title: 'Market Cap'},
              {data: 'stockPrice', title: 'Stock Price'},
              {data: 'unit', title: 'Unit'}]
          });

          // Package #3
          $('#dataTableAggressive').DataTable({
            bAutoWidth: false,
            data: data[2].productBucketDetailEntities,
            columns: [
              {data: 'stockEntity.stockId', title: 'Stock Code'},
              {data: 'stockEntity.marketCap', title: 'Market Cap'},
              {data: 'stockPrice', title: 'Stock Price'},
              {data: 'unit', title: 'Unit'}]
          });
        });
  },
  addAccordion: function (index, title, description, entities, value,
      noofUnit) {
    var titleTemp = `<div class="card-header">
              <i class="fa-solid fa-sack-dollar"></i>
              <span>#Title#</span>
            </div>`
    var replaceText = "Package Name : " + description + " ( " + title + " )";
    titleTemp = titleTemp.replace("#Title#", replaceText);

    var headerDetail = `  <table class="table table-hover">
              <tbody>
              <tr>
                <td><i class="fa-solid fa-id-card-clip"></i> Number Of Unit</td>
                <td><span class="fw-bolder">#noofUnit#</span></td>
              </tr>
              <tr>
                <td><i class="fa-solid fa-user"></i> Value</td>
                <td><span  class="fw-bolder"> #value#</span></td>
              </tr>


              </tbody>
            </table>`;
    headerDetail = headerDetail.replace("#noofUnit#", noofUnit);
    headerDetail = headerDetail.replace("#value#", value);

    var tableBody = `            <table class="table table-hover">
              <thead>
             
                <th>Stock Code</th>
                <th>Market Cap</th>
           
              </thead>
              <tbody>
                 #rows#
              </tbody>
            </table>`;

    var rowTemplate = `  <tr>
                <td> #stockCode#</td>
                <td>#marketCap#</td>
              </tr>`;

    var allrows = '';
    for (const element of entities) {

      var rowOverride = rowTemplate.replace("#stockCode#",
          element.stockEntity.stockId);
      rowOverride = rowOverride.replace("#marketCap#",
          element.stockEntity.marketCap);

      allrows = allrows + rowOverride;

    }

    tableBody = tableBody.replace("#rows#",
        allrows);
    $('.display').append(titleTemp);
    $('.display').append(headerDetail);
    $('.display').append(tableBody);

  }
};

$(document).ready(uiFunctions.init);