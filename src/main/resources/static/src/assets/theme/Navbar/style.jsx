const Style = () => {
    return {
        navOutside: {
            position: "fixed",
            width: {lg: '80%', xs: '100%'},
            zIndex: 10000,
            marginLeft: {lg: '296px', xs: '0'},
            
        },
        nav: {
            display: "flex",
            zIndex: '100000',
            boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1), 0 2px 4px rgba(0, 0, 0, 0.1)",
            
            borderRadius: '7px',
            margin: '0.7rem auto',
            // top: '0', 
            // left:"50%",
            // transform: "translate(-50%, 0)",
            backdropFilter: 'blur(12px)',
            flexDirection: "row-reverse",
            height: '3.7rem',
            padding: "0.5rem 5%",
            alignItems: "center",
            justifyContent: "space-between",
        },
        listMain: {
            display: 'flex',
        },
        menuBox: {
            position: 'absolute',
            top: '100%',
            left: '0',
            border: '1px solid',
            zIndex: '100',
            width: '100%',
            height: '100vh',
            backgroundColor: 'rgba(0, 0, 0, 0.77)',
        },
        
        appDrawer: {
            width: "40%",
            maxWidth: "290px",
            zIndex: "100",
        },
        listMenu: {
            marginTop: '1px',
            position: 'absolute',
            top: '100%',
            left: '0',
            backgroundColor: 'var(--surface)',
            width: {
                xs: '60%',
                sm: '40%',
            },
            zIndex: '100',
            maxWidth: '296px',
            maxHeight: {
                sm: '89vh',
                xs: '89vh'
            },
            "&::-webkit-scrollbar": {
                width: '5px', 
            },
            "&::-webkit-scrollbar-thumb": {
                background: "var(--text)",
                borderRadius: '10px',
                transistion: '0.4s ease',
            },
        },
        nav2: {
            maxWidth: '290px',
            marginTop: '1px',
            height: '100vh',
            background: "#fff",
            position: 'absolute',
            top: '100%',
            zIndex: '100',
            width: {
                xs: '60%',
                sm: '40%',
            },
        },
        listItem: {  
            width: "fit-content",
            cursor: 'pointer',
            marginTop: '0.6rem',
            width: "100%",
            fontSize: '15px',
            textAlign: 'left',
            '&:hover': {
                background: 'var(--dark2)'
            }
        },
        divider: {
            opacity: '0.7',
            fontSize: '14px',
            margin: '1.7rem 0',
        },
        button: {
            color: 'var(--text2)',
            textAlign: 'left',
            '&:hover': {
                background: 'none',
            }
        },
        appDrawer: {
            position: "relative",
            display: {lg: 'block', xs:'none'}
        },
        appDrawerMain2: {
            backgroundColor: 'var(--surface)',
            width: "290px",
            position: 'fixed',
            top: '0',
            height: '100vh',
        },
        appDrawerMain: {
            backgroundColor: 'var(--surface)',
            maxWidth: "290px",
            position: 'fixed',
            width: "40%",
            maxHeight: '100vh',
            overflow: 'auto',

            "&::-webkit-scrollbar": {
                width: '5px', 
            },
            "&::-webkit-scrollbar-thumb": {
                background: "var(--text)",
                borderRadius: '10px',
                transistion: '0.4s ease',
            },
        },
        listItemSocial: {
            padding: "8px",
        },
       
    }
}
export default Style;
