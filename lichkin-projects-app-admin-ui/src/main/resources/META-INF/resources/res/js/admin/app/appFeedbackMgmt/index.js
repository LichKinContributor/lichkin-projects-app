LK.UI.datagrid($.extend((typeof LK.home == 'undefined' ? {
  title : 'title',
  icon : 'appFeedbackMgmt',
} : {}), {
  i18nKey : 'appFeedbackMgmt',
  $appendTo : true,
  cols : 4,
  url : '/SysAppFeedback/P',
  columns : [
      {
        text : 'clientType',
        width : 160,
        name : 'clientType'
      }, {
        text : 'version',
        width : 100,
        formatter : function(rowData) {
          return rowData.versionX + '.' + rowData.versionY + '.' + rowData.versionZ;
        }
      }, {
        text : 'loginName',
        width : 200,
        formatter : function(rowData) {
          if (rowData.loginName == null) {
            return '';
          }
          return rowData.loginName;
        }
      }, {
        text : 'cellphone',
        width : 160,
        formatter : function(rowData) {
          if (rowData.cellphone == null) {
            return '';
          }
          return rowData.cellphone;
        }
      }, {
        text : 'insertTime',
        width : 160,
        formatter : function(rowData) {
          return showStandardTime(rowData.insertTime);
        }
      }, {
        text : 'content',
        width : null,
        name : 'content'
      }
  ],
  pageable : true,
  tools : [
    {
      singleCheck : true,
      icon : 'view',
      text : 'view',
      click : function($button, $datagrid, $selecteds, selectedDatas, value) {
        LK.UI.openDialog($.extend({}, {
          size : {
            cols : 2,
            rows : 4
          }
        }, {
          title : 'view',
          icon : 'view',
          mask : true,
          buttons : [
            {
              text : 'cancel',
              icon : 'cancel',
              cls : 'danger',
              click : function($button, $dialog, $contentBar) {
                $dialog.LKCloseDialog();
              }
            }
          ],
          onAfterCreate : function($dialog, $contentBar) {
            LK.UI.form({
              $appendTo : $contentBar,
              plugins : [
                {
                  plugin : 'cropper',
                  options : {
                    key : 'appFeedbackMgmt.grid.columns.img',
                    name : 'img',
                    value : selectedDatas[0].img,
                    compressWidth : 256,
                    compressHeight : 256,
                    cols : 2,
                    rows : 4,
                    readonly : true
                  }
                }
              ]
            });

            $dialog.find('form').find('textarea').attr('readonly', 'readonly');
          }
        }));
      }
    }
  ],
  searchForm : [
      {
        plugin : 'droplist',
        options : {
          key : 'appKey',
          name : 'appKey',
          param : {
            categoryCode : 'APP_KEY'
          },
          validator : true
        }
      }, {
        plugin : 'droplist',
        options : {
          key : 'clientType',
          name : 'clientType',
          param : {
            categoryCode : 'CLIENT_TYPE',
            excludes : 'JAVASCRIPT'
          }
        }
      }, {
        plugin : 'datepicker',
        options : {
          name : 'startDate'
        }
      }, {
        plugin : 'datepicker',
        options : {
          name : 'endDate'
        }
      }
  ]
}));
