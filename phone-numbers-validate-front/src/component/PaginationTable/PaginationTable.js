import React, {useEffect} from "react";
import TableContainer from "@material-ui/core/TableContainer";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import TableFooter from "@material-ui/core/TableFooter";
import TablePagination from "@material-ui/core/TablePagination";
import {makeStyles, useTheme} from "@material-ui/core/styles";
import IconButton from "@material-ui/core/IconButton";
import LastPageIcon from "@material-ui/icons/LastPage";
import FirstPageIcon from "@material-ui/icons/FirstPage";
import KeyboardArrowRight from "@material-ui/icons/KeyboardArrowRight";
import KeyboardArrowLeft from "@material-ui/icons/KeyboardArrowLeft";
import PropTypes from "prop-types";
import axios from "axios";


const encodedBase64Token = Buffer.from(`abdo:abdo`).toString('base64');
const authorization = `Basic ${encodedBase64Token}`;
const useStyles1 = makeStyles((theme) => ({
    root: {
        flexShrink: 0,
        marginLeft: theme.spacing(2.5),
    },
}));

function TablePaginationActions(props) {
    const classes = useStyles1();
    const theme = useTheme();
    const {count, page, rowsPerPage, onPageChange} = props;

    const handleFirstPageButtonClick = (event) => {
        onPageChange(event, 0);
    };

    const handleBackButtonClick = (event) => {
        onPageChange(event, page - 1);
    };

    const handleNextButtonClick = (event) => {
        onPageChange(event, page + 1);
    };

    const handleLastPageButtonClick = (event) => {
        onPageChange(event, Math.max(0, Math.ceil(count / rowsPerPage) - 1));
    };

    return (
        <div className={classes.root}>
            <IconButton
                onClick={handleFirstPageButtonClick}
                disabled={page === 0}
                aria-label="first page"
            >
                {theme.direction === 'rtl' ? <LastPageIcon/> : <FirstPageIcon/>}
            </IconButton>
            <IconButton onClick={handleBackButtonClick} disabled={page === 0} aria-label="previous page">
                {theme.direction === 'rtl' ? <KeyboardArrowRight/> : <KeyboardArrowLeft/>}
            </IconButton>
            <IconButton
                onClick={handleNextButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="next page"
            >
                {theme.direction === 'rtl' ? <KeyboardArrowLeft/> : <KeyboardArrowRight/>}
            </IconButton>
            <IconButton
                onClick={handleLastPageButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="last page"
            >
                {theme.direction === 'rtl' ? <FirstPageIcon/> : <LastPageIcon/>}
            </IconButton>
        </div>
    );
}

TablePaginationActions.propTypes = {
    count: PropTypes.number.isRequired,
    onPageChange: PropTypes.func.isRequired,
    page: PropTypes.number.isRequired,
    rowsPerPage: PropTypes.number.isRequired,
};


const useStyles2 = makeStyles({
    table: {
        minWidth: 400,
    },
});

const columns = [
    {id: 'name', label: 'Id', minWidth: 170, align: 'center'},
    {id: 'code', label: 'Name', minWidth: 400, align: 'center'},
    {
        id: 'population',
        label: 'Phone',
        minWidth: 170,
        align: 'center'
    }
];
const baseURL = 'http://localhost:8080/api/v1/phone-number';
// const baseURL = 'http://spring-phone-numbers:8080/api/v1/phone-number';

const PaginationTable = (props) => {
    const [pageRows, setPageRows] = React.useState([[]]);
    const [loadedPages, setLoadedPages] = React.useState([]);
    const [totalRows, setTotalRows] = React.useState(0);
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(10);
    const [country, setCountry] = React.useState(props.country);
    const [status, setStatus] = React.useState(props.status);
    useEffect(() => {
        setLoadedPages([]);
        setCountry(props.country);
        setStatus(props.status);
    }, [props.country, props.status]);
    useEffect(() => {
        if (!loadedPages[page]) {
            let filteredURL = '';
            if (country) {
                switch (status) {
                    case 'Valid':
                        filteredURL = `/country/${country}/valid`;
                        break;
                    case 'Not Valid':
                        filteredURL = `/country/${country}/not-valid`;
                        break;
                    default:
                        filteredURL = `/country/${country}`;
                }
            }
            axios.get(`${baseURL}${filteredURL}?pageNumber=${page}`, {
                headers: {
                    Authorization: authorization,
                }
            })
                .then(res => {
                    const customerPage = res.data;
                    setTotalRows(customerPage.totalElements);
                    setLoadedPages(prevState => {
                        prevState[page] = true;
                        return prevState;
                    });
                    setPageRows(prevRows => {

                        prevRows[page] = customerPage.content;

                        return [...prevRows];
                    });
                });
        }
    }, [page, loadedPages, country, status]);

    const classes = useStyles2();
    const emptyRows = rowsPerPage - pageRows[page].length;

    const handleChangePage = (event, newPage) => {
        if (!pageRows[newPage]) {
            setPageRows(prevRows => {
                prevRows[newPage] = [];
                return prevRows;
            });
        }
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    return (
        <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="custom pagination table">
                <TableHead>
                    <TableRow>
                        {columns.map((column) => (
                            <TableCell
                                variant={'head'}
                                key={column.id}
                                align={column.align}
                                style={{minWidth: column.minWidth}}
                            >
                                {column.label}
                            </TableCell>
                        ))}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {(pageRows[page] ? pageRows[page] : []).map((row) => (
                        <TableRow key={row.id}>
                            <TableCell component="th" scope="row" style={{width: 160}} align="center">
                                {row.id}
                            </TableCell>
                            <TableCell style={{width: 400}} align="center">
                                {row.name}
                            </TableCell>
                            <TableCell style={{width: 160}} align="center">
                                {row.phone}
                            </TableCell>
                        </TableRow>
                    ))}

                    {emptyRows > 0 && (
                        <TableRow style={{height: 53 * emptyRows}}>
                            <TableCell colSpan={6}/>
                        </TableRow>
                    )}
                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination
                            rowsPerPageOptions={[10]}
                            colSpan={3}
                            count={totalRows}
                            rowsPerPage={rowsPerPage}
                            page={page}
                            SelectProps={{
                                inputProps: {'aria-label': 'rows per page'},
                                native: true,
                            }}
                            onPageChange={handleChangePage}
                            onRowsPerPageChange={handleChangeRowsPerPage}
                            ActionsComponent={TablePaginationActions}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    );
}

export default PaginationTable;