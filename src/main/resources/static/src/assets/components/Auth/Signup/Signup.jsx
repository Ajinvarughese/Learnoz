import { Box, TextField, Grid, Typography, Button} from "@mui/material";

import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { useState } from "react";
import Style from "./style";


const Signup = () => {

    const styles = Style();

    const [showPassword, setShowPassword] = useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    return (
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
                        Learnoz Signup
                    </Typography>
                    <Typography variant="subtitle1" sx={{marginBottom: '1.1rem'}}>
                        ajana is an idot. Ajana is a mandi. Ajana is not ajana.
                    </Typography>
                    
                    <Box sx={{...styles.formMain,}}>
                        <Box sx={styles.formName}>
                            <TextField id="firstName" label="First name" variant="outlined" />
                            <TextField id="secondName" label="Second name" variant="outlined" />
                        </Box>

                        <TextField id="outlined-basic" label="Email" variant="outlined" />

                        <FormControl sx={{...styles.pass, }} variant="outlined">
                            <InputLabel htmlFor="outlined-adornment-password">Password</InputLabel>
                            <OutlinedInput 
                                id="password"
                                type={showPassword ? 'text' : 'password'}
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

                            
                        </FormControl>

                        <Button variant="contained" sx={styles.submit}>Sign up</Button>
                    </Box>
                </Box>
            </Grid>
        </>
    )
}
export default Signup;
