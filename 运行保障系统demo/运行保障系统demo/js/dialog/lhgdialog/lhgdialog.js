/*
 *@Generator -> Window Dialog Plugins - Build 2009-5-11
 *@Copyright (c) 2009 LiHuiGang - lhgdialog.js
 */

J.exend({

dialog : (function()
{
    var twin = window.parent, cover;
	while( twin.parent && twin.parent != twin )
	{
	    try{ if( twin.parent.document.domain != document.domain ) break; }
		catch(e){break;}
		twin = twin.parent;
	}
	var tdoc = twin.document;
	
	var restyle = function(el)
	{
	    el.style.cssText = 'margin:0;padding:0;background-image:none;background-color:transparent;border:0;';
	};
	
	var getzi = function()
	{
	    if(!J.dialog.cfg.bzi) J.dialog.cfg.bzi = 1999; return ++J.dialog.cfg.bzi;
	};
	
	var getph = function()
	{
	    var bp, len, sc = J('doc').gtag('script');
		for( var i = 0; i < sc.length; i++ )
		{
		    bp = sc[i].src.substring( 0, J.inde(sc[i].src.toLowerCase(),'lhgdialog.js') );
			len = bp.lastIndexOf('/'); if(len>0) bp = bp.substring( 0, len + 1 ); if(bp) break;
		}
		if( J.ie && J.inde(bp,'../') != -1 )
		{
		    var fp = window.location.href; fp = fp.substring( 0, fp.lastIndexOf('/') );
			while( J.inde(bp,'../') >= 0 )
			{
			    bp = bp.substring(3); fp = fp.substring( 0, fp.lastIndexOf('/') );
			}
			return fp + '/' + bp;
		}
		else return bp;
	};
	
	var resizehdl = function()
	{
		if(!cover) return; var rel = J.idtd(tdoc) ? tdoc.documentElement : tdoc.body;
		J(cover).stcs({
		    width: Math.max( rel.scrollWidth, rel.clientWidth, tdoc.scrollWidth || 0 ) - 1 + 'px',
			height: Math.max( rel.scrollHeight, rel.clientHeight, tdoc.scrollHeight || 0 ) - 1 + 'px'
		});
	};
	
	return {
	    cfg : { bzi: null, opac: 0.50, bgcolor: '#fff' }, indoc : {}, infrm : {}, inwin : {},
		get : function(d)
		{
		    if( !d || 'object' != typeof d || J('#lhg_'+d.id) ) return;
			if(d.cover) this.dcover(); else{ if(cover) cover = null; }
			d.width = d.width || 400; d.height = d.height || 300;
			
			var dinfo = { tit: d.title, page: d.page, link: d.link, html: d.html, win: window, top: twin }
			var cize = J.vsiz(twin), pos = J.spos(twin), path = getph();
			
			var itop = d.top ? pos.y + d.top : Math.max( pos.y + ( cize.h - d.height - 20 ) / 2, 0 );
			var ileft = d.left ? pos.x + d.left : Math.max( pos.x + ( cize.w - d.width - 20 ) / 2, 0 );
			
			var dfrm = J(tdoc).crte('iframe'); restyle(dfrm);
			J(dfrm).attr({
			   id: 'lhg_' + d.id, frameBorder: 0, src: path + 'lhgdialog.html'
			}).stcs({
			    top: itop + 'px', left: ileft + 'px', position: 'absolute',
				width: d.width + 'px', height: d.height + 'px', zIndex: getzi()
			});
			J(tdoc.body).apch(dfrm); dfrm._dlgargs = dinfo;
		},
		
		close : function(d,c)
		{
		    var dlg = ( 'object' == typeof(d) ) ? d.frameElement : J('#lhg_'+d);
			if(dlg) J.rech(dlg); if(c) this.hcover(c);
		},
		
		dcover : function()
		{
		    cover = J(tdoc).crte('div'); restyle(cover);
			J(cover).stcs({
				position: 'absolute', zIndex: getzi(), top: '0px',
				left: '0px', backgroundColor: this.cfg.bgcolor
			}).stopac(this.cfg.opac);
			
			if( J.ie && !J.i7 )
			{
			    var ifrm = J(tdoc).crte('iframe'); restyle(ifrm);
				J(ifrm).attr({
				    hideFocus: true, frameBorder: 0, src: J.gtvod()
				}).stcs({
				    width: '100%', height: '100%', position: 'absolute', left: '0px',
					top: '0px', filter: 'progid:DXImageTransform.Microsoft.Alpha(opacity=0)'
				});
				J(cover).apch(ifrm);
			}
			
			J(twin).aevt( 'resize', resizehdl ); resizehdl(); J(tdoc.body).apch(cover);
		},
		
		gcover : function(){ return cover; },
		hcover : function(o){ J.rech(o); cover = null; o = null; }
	};
})()

});	