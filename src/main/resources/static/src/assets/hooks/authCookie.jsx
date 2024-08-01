function checkCookie(props) {
    switch(props) {
        case 'user':
            return localStorage.getItem('user');
        default:
            return null;
    }
}
