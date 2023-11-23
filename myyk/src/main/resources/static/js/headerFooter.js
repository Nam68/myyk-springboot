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
        case 'twitter': url += 'www.twitter.com/'; break;
        case 'instagram': url += 'www.instagram.com/'; break;
        case 'facebook': url += 'facebook.com/'; break;
        case 'steam': url += 'steamcommunity.com/profiles/76561198084622327/'; break;
    }
    window.open(url, '_blank');
}