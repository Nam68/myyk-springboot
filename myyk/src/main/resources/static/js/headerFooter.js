/**
 * HEADER
 */

/**
 * FOOTER
 */

// 푸터 아이콘 클릭
function clickFooterIcon(item) {
    let url = 'https://';
    switch (item) {
        case 'instagram': url += 'www.instagram.com/___im___0916/'; break;
        case 'facebook': url += 'www.facebook.com/youngkyu.nam'; break;
        case 'steam': url += 'steamcommunity.com/profiles/76561198084622327/'; break;
    }
    window.open(url, '_blank');
}