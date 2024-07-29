import { Box, Divider, Grid, List, ListItem, IconButton, Typography } from "@mui/material";
import DehazeIcon from '@mui/icons-material/Dehaze';
import CloseIcon from '@mui/icons-material/Close';
import { useEffect, useState } from "react";
import PersonIcon from '@mui/icons-material/Person';
import Style from "./style";
import LoginIcon from '@mui/icons-material/Login';
import Button from "@mui/material/Button";
import HomeIcon from "@mui/icons-material/Home";
import ProfileIcon from "@mui/icons-material/Person";
import MovieIcon from "@mui/icons-material/Movie";
import BookIcon from "@mui/icons-material/Book";
import CallIcon from "@mui/icons-material/Call";
import InstagramIcon  from "@mui/icons-material/Instagram";
import XIcon from "@mui/icons-material/X";
import GithubIcon from "@mui/icons-material/GitHub";
import ThumpIcon from "@mui/icons-material/ThumbUp";
import TrendingIcon from "@mui/icons-material/TrendingUp";
import YouTubeIcon from "@mui/icons-material/YouTube";

const Navbar = () => {
    const [clicked, setClicked] = useState(false);
    const [scroll, setScroll] = useState(false);
    
    const theme = Style();

    const handleNav = () => {
        setClicked(!clicked);
    }

    useEffect(() => {
        if (clicked) {
            window.scrollTo({top: 0, behavior: 'smooth'});
            document.body.style.overflow = 'hidden';
        } else {
            document.body.style.overflow = 'auto';
        }
    
    }, [clicked]);
    // const handleScroll = () => {
    //     setScroll(!scroll);
    //     console.log("SCROLLED!!!");
    // }
    // useEffect(()=> {
    //     window.addEventListener("scroll", handleScroll);

    // }, []);

    const handleLink = (path) => {
        window.location.href = `/${path}`;
    }


    return (
        <Box sx={theme.navbar}>
            <Box sx={{
                    ...theme.navOutside,
                    paddingLeft: {lg: '0', xs: '0'}
                }}>
                <Grid sx={{
                        ...theme.nav,
                        width: clicked ? '100%' : '97%',
                        maxWidth: clicked ? '100%' : '830px', 
                        top: clicked ? '0' : '10px',
                    }}
                >
                    <Box>
                        <List sx={{...theme.listMain, order: '3'}}>
                            <ListItem sx={theme.listItemSocial}>
                                <InstagramIcon sx={{fontSize: 'small', width: 'fit-content'}}></InstagramIcon>
                            </ListItem>
                            <ListItem sx={theme.listItemSocial}>
                                <XIcon sx={{fontSize: 'small'}}></XIcon>
                            </ListItem>
                            <ListItem sx={theme.listItemSocial}>
                                <GithubIcon sx={{fontSize: 'small'}}></GithubIcon>
                            </ListItem>
                            <ListItem sx={theme.listItemSocial}>
                                <YouTubeIcon sx={{fontSize: 'small'}}></YouTubeIcon>
                            </ListItem>
                        </List>
                    </Box>
                    <Box>
                        <Typography variant="h5" sx={{fontWeight: 600}}>Learnoz</Typography>
                    </Box>
                    <Box sx={{display: {xs: 'block', lg: 'none'}}}>
                        <IconButton onClick={handleNav}>
                            {
                                clicked ? <CloseIcon /> : <DehazeIcon />
                            }
                        </IconButton>
                        
                        <Box 
                            onClick={() => setClicked(!clicked)} 
                            sx={{
                                ...theme.menuBox,
                                display: clicked ? 'block' : 'none',
                            }}
                        >
                        </Box>

                        <Grid >
                            <List sx={{
                                    ...theme.nav2,
                                    left: clicked ? '0' : '-120%',
                                    transition: '0.4s ease',
                                }}
                            >
                            </List>
                            <List sx={{
                                    ...theme.listMenu,
                                    left: clicked ? '0' : '-120%',
                                    transition: '0.4s ease',
                                    overflow: 'auto' 
                                }}
                            >
                                
                                <Divider sx={theme.divider}>Navigation</Divider>
                                
                                <ListItem sx={theme.listItem} onClick={() => handleLink('')} >
                                    <Button variant="text" sx={theme.button}>
                                        <HomeIcon sx={{fontSize: 'large'}}></HomeIcon>
                                        <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Home</Typography>
                                    </Button>
                                </ListItem>
                                <ListItem sx={theme.listItem} onClick={() => handleLink('profile')} >
                                    <Button variant="text" sx={theme.button}>
                                        <ProfileIcon sx={{fontSize: 'medium'}}></ProfileIcon>
                                        <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Profile</Typography>
                                    </Button>
                                </ListItem>
                                <ListItem sx={theme.listItem} onClick={() => handleLink('courses')} >
                                    <Button variant="text" sx={theme.button}>
                                        <MovieIcon sx={{fontSize: 'medium'}}></MovieIcon>
                                        <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Courses</Typography>
                                    </Button>
                                </ListItem>
                                <ListItem sx={theme.listItem} onClick={() => handleLink('liked-videos')} >
                                    <Button variant="text" sx={theme.button}>
                                        <ThumpIcon sx={{fontSize: 'medium'}}></ThumpIcon>
                                        <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Liked</Typography>
                                    </Button>
                                </ListItem>
                                <ListItem sx={theme.listItem}>
                                    <Button variant="text" sx={theme.button} onClick={() => handleLink('trending')} >
                                        <TrendingIcon sx={{fontSize: 'medium'}}></TrendingIcon>
                                        <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Trending</Typography>
                                    </Button>
                                </ListItem>
                                
                                <Divider sx={theme.divider}>Get Started</Divider>
                                
                                <ListItem sx={theme.listItem} onClick={() => handleLink('signup')}>
                                    <Button variant="text" sx={theme.button}>
                                        <PersonIcon sx={{fontSize: 'medium'}}></PersonIcon>
                                        <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Sign Up</Typography>
                                    </Button>
                                </ListItem>

                                <ListItem sx={theme.listItem} onClick={() => handleLink('login')}>
                                    <Button variant="text" sx={theme.button}>
                                        <LoginIcon sx={{fontSize: 'medium'}}></LoginIcon>
                                        <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Log In</Typography>
                                    </Button>
                                </ListItem>
                                
                                
                                <Divider sx={theme.divider}>Policies</Divider>
                                
                                <ListItem sx={theme.listItem}>Home</ListItem>
                                <ListItem sx={theme.listItem}>About</ListItem>
                                <ListItem sx={theme.listItem}>Courses</ListItem>
                                <ListItem sx={theme.listItem}>Blog</ListItem>
                                <ListItem sx={theme.listItem}>Contact</ListItem>
                                <br />
                            </List>
                        </Grid>
                    </Box>
                </Grid>
            </Box>

            <Grid sx={{...theme.appDrawer,}}>
                <List sx={{
                        ...theme.appDrawerMain2,
                        transition: '0.4s ease',
                    }}
                >
                </List>
                <List sx={{
                        ...theme.appDrawerMain,
                        transition: '0.4s ease',
                        overflow: 'auto',
                        width: '540px',
                    }}
                >
                    
                    <Divider sx={theme.divider}>Navigation</Divider>
                    
                    <ListItem sx={theme.listItem} onClick={() => handleLink('')} >
                        <Button variant="text" sx={theme.button}>
                            <HomeIcon sx={{fontSize: 'large'}}></HomeIcon>
                            <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Home</Typography>
                        </Button>
                    </ListItem>
                    <ListItem sx={theme.listItem} onClick={() => handleLink('profile')} >
                        <Button variant="text" sx={theme.button}>
                            <ProfileIcon sx={{fontSize: 'medium'}}></ProfileIcon>
                            <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Profile</Typography>
                        </Button>
                    </ListItem>
                    <ListItem sx={theme.listItem} onClick={() => handleLink('courses')} >
                        <Button variant="text" sx={theme.button}>
                            <MovieIcon sx={{fontSize: 'medium'}}></MovieIcon>
                            <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Courses</Typography>
                        </Button>
                    </ListItem>
                    <ListItem sx={theme.listItem} onClick={() => handleLink('liked-videos')} >
                        <Button variant="text" sx={theme.button}>
                            <ThumpIcon sx={{fontSize: 'medium'}}></ThumpIcon>
                            <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Liked</Typography>
                        </Button>
                    </ListItem>
                    <ListItem sx={theme.listItem}>
                        <Button variant="text" sx={theme.button} onClick={() => handleLink('trending')} >
                            <TrendingIcon sx={{fontSize: 'medium'}}></TrendingIcon>
                            <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Trending</Typography>
                        </Button>
                    </ListItem>

                    <Divider sx={theme.divider}>Get Started</Divider>
                                
                    <ListItem sx={theme.listItem} onClick={() => handleLink('signup')}>
                        <Button variant="text" sx={theme.button}>
                            <PersonIcon sx={{fontSize: 'medium'}}></PersonIcon>
                            <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Sign Up</Typography>
                        </Button>
                    </ListItem>

                    <ListItem sx={theme.listItem} onClick={() => handleLink('login')}>
                        <Button variant="text" sx={theme.button}>
                            <LoginIcon sx={{fontSize: 'medium'}}></LoginIcon>
                            <Typography sx={{marginLeft: '7px', fontSize: '14px',}}>Log In</Typography>
                        </Button>
                    </ListItem>
                    
                    <Divider sx={theme.divider}>Policies</Divider>
                    
                    <ListItem sx={theme.listItem}>Home</ListItem>
                    <ListItem sx={theme.listItem}>About</ListItem>
                    <ListItem sx={theme.listItem}>Courses</ListItem>
                    <ListItem sx={theme.listItem}>Blog</ListItem>
                    <ListItem sx={theme.listItem}>Contact</ListItem>
                    <br />
                </List>
            </Grid>
        </Box>
    );
}

export default Navbar;
