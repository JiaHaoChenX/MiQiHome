var pageModel = function(currentPage, pageSize, totalCount) {
	this.currentPage = currentPage;
	this.pageSize = pageSize;
	this.totalCount = totalCount;
	this.getPageCount = function() {
		var pageCount = 0;
		if (pageSize != 0) {
			pageCount = parseInt(totalCount / pageSize);
			if (totalCount % pageSize != 0)
				pageCount++;
		}
		return pageCount;
	},
	this.getCurrentPage = function() {
		var currentPage = this.currentPage < this.getPageCount() ? this.currentPage
				: this.getPageCount();
		currentPage = currentPage < 1 ? 1 : currentPage;
		return currentPage;
	},
	this.isHaveNextPage = function() {
		var havaNextPage = false;
		if ((this.getPageCount() > 1) && (this.getPageCount() > this.getCurrentPage()))
			havaNextPage = true;
		return havaNextPage;
	},
	this.isHavePrePage=function()
	{
		var havePrePage = false;
		if ((this.getPageCount() > 1) && (this.currentPage > 1))
			havePrePage = true;
		return havePrePage;
	},	
    this.getCurrentPageItem=function(){
        var  currentPageItem = new Array();
        var pageCount = this.getPageCount();
        for(var i=currentPage-5;i<=pageCount && i<currentPage+5;i++){
            if(i<=0){
                continue;
            }
            currentPageItem.push(i);
        }
		return currentPageItem;
    }

  } 