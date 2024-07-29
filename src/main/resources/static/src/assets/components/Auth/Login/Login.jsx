import Style from './style';
import { Box, TextField, Grid, Typography, Button, Select, MenuItem, FormHelperText} from "@mui/material";

import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import LoadingButton from "@mui/lab/LoadingButton";
import { useState } from 'react';

const styles = Style();

function Login() {

    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    const [isLoading, setIsLoading] = useState(false);

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [emailError, setEmailError] = useState(false);
    const [passwordError, setPasswordError] = useState(false);

    const validateForm = (event) => {
        event.preventDefault();
        setIsLoading(true);

        let setted = true;

        let loginData = {
            email: email,
            username: email,
            password: password,
        }


        if(email === ''){
            setEmailError(true);
            setted = false;
        }
        if(password === ''){
            setPasswordError(true);
            setted = false;
        }

        if(setted) {
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if(emailRegex.test(email)) {
                loginData = {
                    email: email,
                    username: '',
                    password: password
                }
            }else {
                loginData = {
                    email: '',
                    username: email,
                    password: password
                }
            }

            console.log(loginData);
            
        }else {
            setIsLoading(false);
            return false;
        }
        
    }

    const [label, setLabel] = useState('Email or username'); 

    return(
        <>
            <Grid sx={{...styles.signup}}>
                <Box
                    component="form"
                    sx={{
                        ...styles.formOuter

                    }}
                    noValidate
                    autoComplete="off"
                    >
                    <Typography variant="h5" sx={{fontWeight: 600,}}>
                        Learnoz Login
                    </Typography>
                    <Typography variant="subtitle1" sx={{marginBottom: '1.1rem', color: 'var(--text2)'}}>
                        Welcome back, Let's log into learnoz 
                    </Typography>
                    
                    <Box sx={{...styles.formMain,}}>
                        <TextField 
                            id="outlined-basic" 
                            label={label}
                            onFocus={
                                () => {
                                    setLabel('Email')
                                }
                            } 
                            onBlur={
                                () => {
                                    if(email === '') {
                                        setLabel('Email or username') 
                                    }else {
                                        setLabel('Email');
                                    }
                                }
                            }
                            variant="outlined" 
                            error={(emailError)}
                            helperText={emailError ? "Enter a valid email or username" : ""}
                            onChange={(event) => setEmail(event.target.value)}
                            onInput={() => {
                                setEmailError(false); 
                            }}
                        />

                        <FormControl sx={...styles.pass} variant="outlined" error={passwordError}>
                            <InputLabel htmlFor="outlined-adornment-password">Password</InputLabel>
                            <OutlinedInput 
                                id="password"
                                type={showPassword ? 'text' : 'password'}
                                onInput={() => {setPasswordError(false)}}
                                onChange={(event) => setPassword(event.target.value)}
                                endAdornment={
                                <InputAdornment position="end">
                                    <IconButton
                                    aria-label="toggle password visibility"
                                    onClick={handleClickShowPassword}
                                    onMouseDown={handleMouseDownPassword}
                                    edge="end"
                                    >
                                    {showPassword ? <VisibilityOff /> : <Visibility />}
                                    </IconButton>
                                </InputAdornment>
                                }
                                label="Password"
                            />
                            {passwordError && <FormHelperText>Please enter a valid password</FormHelperText>}
                        </FormControl>

                        <LoadingButton loading={isLoading} onClick={validateForm} variant="contained" sx={styles.submit}>Log In</LoadingButton>
                    </Box>
                </Box>
            </Grid>
        </>  
    );
}
export default Login;