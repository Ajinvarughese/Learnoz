const Style = () => {
    return {
        signup: {
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            width: '100%',
            height: '100vh',
            minHeight: '690px'
        },
        formOuter: {
            width: {xs: '76%', sm: '430px'},
            border: '3px solid #2e82d6',
            padding: '1.4rem 3rem',
            borderRadius: '7px'
        },
        formMain: {
            display: 'flex',
            
            flexDirection: 'column',
            "& >:not(style)": {
                marginTop: '0.7rem',
            }
        },
        formName: {
            display: 'flex',
            flexDirection: {
                xs: 'column',
                sm: 'row',
            },
            gap: '0.4rem',
        },
        pass: {
            margin: '0',
        },
    }
}
export default Style;